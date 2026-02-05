package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2482 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] dp;
    static final int MOD = 1_000_000_003;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        if (K > N / 2) {
            System.out.println(0);
            return;
        }

        dp = new int[N + 1][K + 1];
        dp[2][1] = 2;

        for (int color = 3; color <= N; color++) {
            dp[color][1] = color;

            for (int k = 2; k <= K; k++) {
                dp[color][k] = dp[color - 1][k] + dp[color - 2][k - 1];
                dp[color][k] %= MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}
