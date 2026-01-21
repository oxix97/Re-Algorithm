package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] A, dp;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, find(i, j));
            }
        }

        System.out.println(answer);
    }

    private static int find(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int y = dy[k] + i;
            int x = dx[k] + j;

            if (0 <= y && y < N && 0 <= x && x < N && A[y][x] > A[i][j]) {
                dp[i][j] = Math.max(dp[i][j], find(y, x) + 1);
            }
        }

        return dp[i][j];
    }
}
