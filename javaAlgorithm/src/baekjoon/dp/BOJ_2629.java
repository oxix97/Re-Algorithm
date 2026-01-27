package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] weight;
    static boolean[][] dp;
    static final int MAX = 15000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][MAX + 1];

        dfs(0, 0);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int ball = Integer.parseInt(st.nextToken());

            if (ball > MAX) {
                sb.append("N ");
            } else {
                if (dp[N][ball]) {
                    sb.append("Y ");
                } else {
                    sb.append("N ");
                }
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int idx, int current) {
        if (dp[idx][current])
            return;

        dp[idx][current] = true;

        if (idx == N)
            return;

        dfs(idx + 1, current + weight[idx]);

        dfs(idx + 1, Math.abs(current - weight[idx]));

        dfs(idx + 1, current);
    }
}
