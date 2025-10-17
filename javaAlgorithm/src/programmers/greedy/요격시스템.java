package programmers.greedy;

import java.util.Arrays;

public class 요격시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets,(o1, o2) -> o1[1] - o2[1]);
        int answer = 1;
        int prev = targets[0][1];
        for(int i=1;i<targets.length;i++){
            if(prev > targets[i][0])
                continue;
            answer += 1;
            prev = targets[i][1];
        }

        return answer;
    }
}
