package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0, 1, 0});
        int answer = 0;
        while (!q.isEmpty()) {
            int[] n = q.removeFirst();
            if (n[0] == N - 1 && n[1] == N - 1) {
                answer += 1;
                continue;
            }

            if (n[2] <= 1 && check(n[0], n[1] + 1)) {
                q.addLast(new int[]{n[0], n[1] + 1, 0});
            }
            if (n[2] >= 1 && check(n[0] + 1, n[1])) {
                q.addLast(new int[]{n[0] + 1, n[1], 2});
            }
            if (check(n[0], n[1] + 1) && check(n[0] + 1, n[1]) && check(n[0] + 1, n[1] + 1)) {
                q.addLast(new int[]{n[0] + 1, n[1] + 1, 1});
            }
        }

        System.out.println(answer);
    }

    private static boolean check(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N && A[y][x] == 0;
    }
}
