package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_2240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, W;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        dp = new int[T + 1][W + 1];
        dp[1][0] = Integer.MIN_VALUE;

        for (int i = 1; i <= T; i++) {
            int now = Integer.parseInt(br.readLine());

            for (int j = 0; j <= W; j++) {
                int current = j % 2 == 0 ? 1 : 2;
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                if (now == current) {
                    dp[i][j] += 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= W; i++)
            answer = Math.max(answer, dp[T][i]);

        System.out.println(answer);
    }
}
