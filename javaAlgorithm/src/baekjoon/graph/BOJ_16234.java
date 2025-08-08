package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solution() {
        int answer = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean move = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            move = true;
                        }
                    }
                }
            }
            if (!move) break;
            answer++;
        }

        System.out.println(answer);
    }

    private static boolean bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> union = new LinkedList<>();
        q.add(new int[]{y, x});
        union.add(new int[]{y, x});

        visited[y][x] = true;
        int sum = A[y][x];
        int count = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if (rangeException(ny, nx) || visited[ny][nx]) continue;
                if (validation(A[now[0]][now[1]], A[ny][nx])) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                    union.add(new int[]{ny, nx});
                    sum += A[ny][nx];
                    count++;
                }
            }
        }

        if (count > 1) {
            int avg = sum / count;
            for (int[] idx : union) {
                int ny = idx[0];
                int nx = idx[1];
                A[ny][nx] = avg;
            }
            return true;
        }
        return false;
    }

    private static boolean validation(int a, int b) {
        int v = Math.abs(a - b);
        return L <= v && v <= R;
    }

    private static boolean rangeException(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }
}
