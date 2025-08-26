package programmers.greedy;

import java.util.Arrays;

public class 최고의집합 {
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[] {-1};
        }

        int[] answer = new int[n];
        int quo = s / n;
        int rem = s % n;
        Arrays.fill(answer,quo);
        for(int i=0;i < rem;i++){
            answer[n - 1 - i] += 1;
        }
        return answer;
    }
}
