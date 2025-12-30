package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp = new boolean[N][N];
        for (int len = 1; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;

                if (arr[i] == arr[j]) {
                    if (len <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            int result = dp[start][end] ? 1 : 0;
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
