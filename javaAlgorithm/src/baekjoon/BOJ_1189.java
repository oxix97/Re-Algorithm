package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, K;
    static boolean[][] visit;
    static char[][] arr;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }

        visit = new boolean[R][C];
        dfs(R - 1, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int y, int x, int dist) {
        if (dist > K) {
            return;
        }
        if (y == 0 && x == C - 1 && dist == K) {
            answer += 1;
            return;
        }

        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < R && nx >= 0 && nx < C && !visit[ny][nx] && arr[ny][nx] != 'T') {
                dfs(ny, nx, dist + 1);
            }
        }
        visit[y][x] = false;
    }
}
