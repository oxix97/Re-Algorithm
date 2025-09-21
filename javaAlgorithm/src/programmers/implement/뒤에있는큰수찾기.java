package programmers.implement;

import java.util.ArrayDeque;
import java.util.Deque;

public class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<len;i++){
            while(!q.isEmpty() && numbers[q.peekLast()] < numbers[i]){
                answer[q.removeLast()] = numbers[i];
            }
            q.addLast(i);
        }

        while(!q.isEmpty()){
            answer[q.pop()] = -1;
        }

        return answer;
    }
}
