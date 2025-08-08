package book.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */
public class 금광 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M;
    static int[][] arr;
    static int[][] dp;

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = arr[i][j];
            }
        }
    }

    private static void solution() {
        for (int j = 2; j <= M; j++) {
            for (int i = 1; i <= N; i++) {
                int up = (i == 1) ? 1 : dp[i - 1][j - 1];
                int down = (i == N) ? 1 : dp[i + 1][j - 1];
                int left = dp[i][j - 1];
                dp[i][j] += Math.max(up, Math.max(down, left));
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i][M]);
        }
        sb.append(max).append('\n');
    }

    private static void output() {
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            inputs();
            solution();
        }
        output();
    }
}
