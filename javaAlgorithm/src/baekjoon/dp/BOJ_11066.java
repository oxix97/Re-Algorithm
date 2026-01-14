package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] A = new int[K + 1];
            int[] S = new int[K + 1];
            for (int j = 1; j <= K; j++) {
                A[j] = Integer.parseInt(st.nextToken());
                S[j] = S[j - 1] + A[j];
            }

            solv(K, S);
        }
    }

    private static void solv(int n, int[] sum) {
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                int psum = sum[j] - sum[i - 1];
                dp[i][j] = INF;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + psum);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
