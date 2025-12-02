package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1600 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int K, W, H;
    static int[][] A;
    static boolean[][][] visit;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] hy = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] hx = {2, -2, 2, -2, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        A = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[H][W][K + 1];
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.removeFirst();

            if (now.y == H - 1 && now.x == W - 1) {
                System.out.println(now.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + now.y;
                int nx = dx[i] + now.x;

                if (0 <= ny && ny < H && 0 <= nx && nx < W && A[ny][nx] == 0 && !visit[ny][nx][now.jump]) {
                    visit[ny][nx][now.jump] = true;
                    q.addLast(new Node(ny, nx, now.dist + 1, now.jump));
                }
            }

            if (now.jump < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = hy[i] + now.y;
                    int nx = hx[i] + now.x;

                    if (0 <= ny && ny < H && 0 <= nx && nx < W && A[ny][nx] == 0 && !visit[ny][nx][now.jump + 1]) {
                        visit[ny][nx][now.jump + 1] = true;
                        q.addLast(new Node(ny, nx, now.dist + 1, now.jump + 1));
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
        int jump;

        public Node(int y, int x, int dist, int jump) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.jump = jump;
        }
    }
}
