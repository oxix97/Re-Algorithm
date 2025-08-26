package programmers.binary;

import java.util.Arrays;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0;
        int b = 0;
        int len = A.length;

        while(b < len){
            if(B[b++] > A[a]){
                a += 1;
            }
        }

        return a;
    }
}
