package programmers.kit.greedy;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes,(o1, o2) -> o1[1] - o2[1]);
        int answer = 0;
        for(int i=0;i<routes.length;i++){
            int pos = routes[i][1];
            while (i < routes.length -1 && pos >= routes[i + 1][0]){
                i += 1;
            }

            answer += 1;
        }

        return answer;
    }
}
