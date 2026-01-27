package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int t = T[i];
            int p = P[i];

            if (i + t <= N + 1) {
                dp[i + t] = Math.max(dp[i + t], dp[i] + p);
            }
        }

        System.out.println(Math.max(dp[N], dp[N + 1]));
    }
}
