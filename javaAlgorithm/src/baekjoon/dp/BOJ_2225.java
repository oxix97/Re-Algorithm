package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2225 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];
        Arrays.fill(dp[1], 1);

        for (int k = 2; k <= K; k++) {
            dp[k][0] = dp[k - 1][0];
            for (int n = 1; n <= N; n++) {
                dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % MOD;
            }
        }

        System.out.println(dp[K][N]);
    }
}
