package org.example.book.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        inputs();
        bfs();
        System.out.println(arr[N][M]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(1);
        visited[1][1] = true;
        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (outOfRange(ny, nx) || visited[ny][nx] || arr[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                arr[ny][nx] = arr[y][x] + 1;
                q.add(ny);
                q.add(nx);
            }
        }
    }

    private static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(line[j - 1]);
            }
        }
    }

    private static boolean outOfRange(int y, int x) {
        return y > N || x > M || y < 1 || x < 1;
    }
}
