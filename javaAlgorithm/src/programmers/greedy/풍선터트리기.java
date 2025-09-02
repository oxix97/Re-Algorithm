package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 풍선터트리기 {
    public int solution(int[] a) {
        int N = a.length;
        if(N <= 2){
            return N;
        }

        int[] minLeft = new int[N];
        minLeft[0] = a[0];
        for(int i=1;i< N;i++){
            minLeft[i] = Math.min(minLeft[i - 1],a[i]);
        }

        int[] minRight = new int[N];
        minRight[N - 1] = a[N - 1];
        for(int i = N - 2;i>=0;i--){
            minRight[i] = Math.min(minRight[i + 1],a[i]);
        }

        int answer = 2;
        for(int i=1;i<N - 1;i++){
            if(a[i] < minLeft[i - 1] || a[i] < minRight[i + 1])
                answer += 1;
        }
        return answer;
    }
}
