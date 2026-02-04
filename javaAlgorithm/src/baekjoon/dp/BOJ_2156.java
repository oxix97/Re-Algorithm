package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] A, dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(A[1]);
            return;
        }
        if (N == 2) {
            System.out.println(A[1] + A[2]);
            return;
        }

        dp = new int[N + 1];
        dp[1] = A[1];
        dp[2] = A[1] + A[2];

        for (int i = 3; i <= N; i++) {
            int a = dp[i - 3] + A[i - 1] + A[i];
            int b = dp[i - 2] + A[i];
            dp[i] = Math.max(Math.max(a, b), dp[i - 1]);
        }

        System.out.println(dp[N]);
    }
}
