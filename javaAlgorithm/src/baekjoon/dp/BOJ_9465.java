package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                sticker[0][j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                sticker[1][j] = Integer.parseInt(st.nextToken());

            int answer = solution(sticker, n);
            System.out.println(answer);
        }
    }

    private static int solution(int[][] sticker, int n) {
        if (n == 1)
            return Math.max(sticker[0][0], sticker[1][0]);

        int[][] dp = new int[2][n];
        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];

        dp[0][1] = dp[1][0] + sticker[0][1];
        dp[1][1] = dp[0][0] + sticker[1][1];

        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1] + sticker[0][i], dp[1][i - 2] + sticker[0][i]);
            dp[1][i] = Math.max(dp[0][i - 1] + sticker[1][i], dp[0][i - 2] + sticker[1][i]);
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
