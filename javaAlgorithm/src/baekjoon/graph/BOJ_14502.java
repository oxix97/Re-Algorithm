package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static int answer = 0;

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solution(int cnt) {
        //2. 가스 살포
        if (cnt == 0) {
            spread();
            return;
        }
        //1. 벽을 세운다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] == 0) {
                    visited[i][j] = true;
                    graph[i][j] = 1;
                    solution(cnt - 1);
                    visited[i][j] = false;
                    graph[i][j] = 0;
                }
            }
        }
    }

    private static void spread() {
        int[][] room = new int[N][M];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = graph[i][j];
                if (room[i][j] == 2) {
                    q.add(i);
                    q.add(j);
                }
            }
        }

        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (rangeException(ny, nx)) continue;
                if (room[ny][nx] == 0) {
                    room[ny][nx] = 2;
                    q.add(ny);
                    q.add(nx);
                }
            }
        }

        //3. 0 개수 확인
        int count = 0;
        for (int[] b : room) {
            for (int a : b) {
                if (a == 0) ++count;
            }
        }

        //4. 최대 0 개수 -> 결과
        answer = Math.max(answer, count);
    }

    private static boolean rangeException(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= M;
    }

    private static void output() {
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution(3);
        output();
    }
}
