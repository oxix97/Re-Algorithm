package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M, N;
    static int[][] A;
    static int[][] dp;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++)
            Arrays.fill(dp[i], -1);

        int answer = dfs(1, 1);
        System.out.println(answer);

    }

    private static int dfs(int y, int x) {
        if (y == M && x == N) {
            return 1;
        }

        if (dp[y][x] != -1)
            return dp[y][x];

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (rangeMatch(ny, nx) && A[y][x] > A[ny][nx]) {
                dp[y][x] += dfs(ny, nx);
            }
        }

        return dp[y][x];
    }

    private static boolean rangeMatch(int ny, int nx) {
        return 1 <= ny && ny <= M && 1 <= nx && nx <= N;
    }
}
