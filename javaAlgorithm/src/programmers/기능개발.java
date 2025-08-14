package programmers;

import java.util.*;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<speeds.length;i++){
            int other = 100 - progresses[i];
            int cnt = other / speeds[i];
            if(other % speeds[i] != 0){
                cnt += 1;
            }
            q.addLast(cnt);
        }

        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()){
            int day = q.removeFirst();
            int cnt = 1;
            while (!q.isEmpty()){
                if(q.peekFirst() <= day){
                    q.removeFirst();
                    cnt += 1;
                    continue;
                }
                break;
            }

            answer.add(cnt);
        }

        return answer.stream()
                .mapToInt(it->it)
                .toArray();
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        print(answer);
    }

    private static void print(int[] answer) {
        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}
