package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_16724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static char[][] A;
    static boolean[][] visit, cycle;
    static int answer = 0;

    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().toCharArray();
        }

        visit = new boolean[N][M];
        cycle = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;

        int d = dir(A[y][x]);
        int ny = y + dy[d];
        int nx = x + dx[d];

        if (!visit[ny][nx])
            dfs(ny, nx);
        else if (!cycle[ny][nx])
            answer += 1;

        cycle[y][x] = true;
    }

    private static int dir(Character c) {
        if (c == 'U')
            return 0;
        if (c == 'D')
            return 1;
        if (c == 'L')
            return 2;
        return 3;
    }
}