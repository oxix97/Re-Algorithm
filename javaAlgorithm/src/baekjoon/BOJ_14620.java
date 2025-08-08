package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(3, 0);
        System.out.println(answer);
    }

    private static void recursion(int cnt, int cost) {
        if (cnt == 0) {
            answer = Math.min(answer, cost);
            return;
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                boolean check = visit[i][j];
                int v = arr[i][j];
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    check = check || visit[ny][nx];
                    v += arr[ny][nx];
                }
                if (!check) {
                    visit[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        visit[ny][nx] = true;
                    }
                    recursion(cnt - 1, cost + v);
                    visit[i][j] = false;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        visit[ny][nx] = false;
                    }
                }
            }
        }
    }
}
