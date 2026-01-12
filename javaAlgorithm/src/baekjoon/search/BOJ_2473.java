package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long[] A;
    static long answer = Long.MAX_VALUE;
    static long[] result;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        result = new long[3];
        for (int i = 0; i < N - 2; i++) {
            solv(i);
        }

        StringBuilder sb = new StringBuilder();
        for (long n : result)
            sb.append(n).append(' ');
        System.out.println(sb);
    }

    private static void solv(int idx) {
        int left = idx + 1;
        int right = N - 1;

        while (left < right) {
            long sum = A[idx] + A[left] + A[right];

            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
                result[0] = A[idx];
                result[1] = A[left];
                result[2] = A[right];
            }

            if (sum > 0) {
                right -= 1;
            } else {
                left += 1;
            }
        }
    }
}
