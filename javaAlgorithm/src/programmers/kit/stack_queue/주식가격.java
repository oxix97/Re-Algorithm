package programmers.kit.stack_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class 주식가격 {
    public static int[] solution(int[] prices) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length;i++){
            while(!q.isEmpty() && prices[i] < prices[q.peekLast()]){
                int top = q.removeLast();
                answer[top] = i - top;
            }
            q.addLast(i);
        }

        while(!q.isEmpty()){
            int top = q.removeLast();
            answer[top] = prices.length - 1 - top;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 2, 3, 2, 3});
        List<Integer> answer = Arrays.stream(result)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(answer);
    }
}
