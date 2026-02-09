package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_5557 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] A;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[N + 1][21];
        dp[1][A[1]] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] == 0)
                    continue;

                if (j + A[i] <= 20)
                    dp[i][j + A[i]] += dp[i - 1][j];
                if (0 <= j - A[i])
                    dp[i][j - A[i]] += dp[i - 1][j];
            }
        }

        System.out.println(dp[N - 1][A[N]]);
    }
}