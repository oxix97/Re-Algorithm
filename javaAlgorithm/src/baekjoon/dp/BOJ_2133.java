package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp = new long[N + 1];
        dp[0] = 1;
        dp[2] = 3;
        long sum = 0;
        for (int n = 4; n <= N; n += 2) {
            sum += dp[n - 4] * 2;

            dp[n] = (dp[n - 2] * 3) + sum;
        }

        System.out.println(dp[N]);
    }
}
