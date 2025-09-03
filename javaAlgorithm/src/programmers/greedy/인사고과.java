package programmers.greedy;

import java.util.*;

public class 인사고과 {
    public int solution(int[][] scores) {
        int a = scores[0][0];
        int b = scores[0][1];

        Arrays.sort(scores,(o1,o2)->{
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o2[0]-o1[0];
        });

        int maxB = -1;
        int rank = 1;
        for(int[] s : scores){
            if(s[1] < maxB){
                if(a == s[0] && b == s[1])
                    return -1;
                continue;
            }

            if(s[0] + s[1] > a + b)
                rank += 1;

            maxB = Math.max(maxB,s[1]);
        }

        return rank;
    }
}
