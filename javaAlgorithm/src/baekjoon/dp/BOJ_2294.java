package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());

            for (int j = coin; j < dp.length; j++) {
                if (dp[j - coin] != INF) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}
