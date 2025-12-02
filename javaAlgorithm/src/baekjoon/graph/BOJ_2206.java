package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N;
    static int M;
    static int[][] A;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visit = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] sp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(sp[j]);
            }
        }

        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            if (now.y == N - 1 && now.x == M - 1) {
                System.out.println(now.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + now.y;
                int nx = dx[i] + now.x;

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;

                if (A[ny][nx] == 1) {
                    if (now.broke == 0 && !visit[ny][nx][1]) {
                        visit[ny][nx][1] = true;
                        q.addLast(new Node(ny, nx, now.dist + 1, 1));
                    }
                } else {
                    if (!visit[ny][nx][now.broke]){
                        visit[ny][nx][now.broke] = true;
                        q.addLast(new Node(ny, nx, now.dist + 1, now.broke));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Node {
        int y;
        int x;
        int dist;
        int broke;

        public Node(int y, int x, int dist, int broke) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.broke = broke;
        }
    }
}
