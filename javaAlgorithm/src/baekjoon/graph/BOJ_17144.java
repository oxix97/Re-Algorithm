package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, T;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int idx;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            if (graph[i][0] == -1) {
                idx = i;
                break;
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            rotate90();
            rotateCounter90();
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == -1)
                    continue;
                answer += graph[i][j];
            }
        }
        System.out.println(answer);
    }

    private static void rotate90() {
        for (int i = idx + 2; i < R - 1; i++) {
            graph[i][0] = graph[i + 1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            graph[R - 1][j] = graph[R - 1][j + 1];
        }
        for (int i = R - 1; i > idx + 1; i--) {
            graph[i][C - 1] = graph[i - 1][C - 1];
        }
        for (int j = C - 1; j > 1; j--) {
            graph[idx + 1][j] = graph[idx + 1][j - 1];
        }
        graph[idx + 1][1] = 0;
    }

    private static void rotateCounter90() {
        for (int i = idx - 1; i > 0; i--) {
            graph[i][0] = graph[i - 1][0];
        }
        for (int j = 0; j < C - 1; j++) {
            graph[0][j] = graph[0][j + 1];
        }
        for (int i = 0; i < idx; i++) {
            graph[i][C - 1] = graph[i + 1][C - 1];
        }
        for (int j = C - 1; j > 1; j--) {
            graph[idx][j] = graph[idx][j - 1];
        }
        graph[idx][1] = 0;
    }

    private static void spread() {
        int[][] tmp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == -1) {
                    tmp[i][j] = -1;
                    continue;
                }
                if (graph[i][j] == 0)
                    continue;

                int amount = graph[i][j] / 5;
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int ny = dy[k] + i;
                    int nx = dx[k] + j;
                    if (0 <= ny && ny < R && 0 <= nx && nx < C && graph[ny][nx] != -1) {
                        tmp[ny][nx] += amount;
                        count++;
                    }
                }
                tmp[i][j] += graph[i][j] - (amount * count);
            }
        }
        graph = tmp;
    }
}
