package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2638 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] A;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<int[]> cheeses;

//1. 맨 가장자리부터 시작하여 외부공기와 내부 공기를 판별
//2. 치즈들중 2면이 외부와 닿아있는 치즈들을 표시
//3. 표식이 있는 치즈 제거
//4. 치즈가 없어질 때 까지 반복
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        cheeses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 1)
                    cheeses.add(new int[]{i, j});
            }
        }

        int answer = 0;

        while (!cheeses.isEmpty()) {
            boolean[][] visit = new boolean[N][M];
            dfs(visit, 0, 0);
            meltCheese(visit);
            answer += 1;
        }

        System.out.println(answer);
    }

    private static void meltCheese(boolean[][] visit) {
        List<int[]> survive = new ArrayList<>();
        List<int[]> result = new ArrayList<>();

        for (int[] n : cheeses) {
            int y = n[0];
            int x = n[1];
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (rangeCheck(ny, nx) && visit[ny][nx])
                    count += 1;
            }
            if (count >= 2)
                result.add(new int[]{y, x});
            else
                survive.add(new int[]{y, x});
        }

        for (int[] n : result) {
            A[n[0]][n[1]] = 0;
        }

        cheeses = survive;
    }

    private static void dfs(boolean[][] visit, int y, int x) {
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (rangeCheck(ny, nx) && A[ny][nx] == 0 && !visit[ny][nx]) {
                dfs(visit, ny, nx);
            }
        }
    }

    private static boolean rangeCheck(int ny, int nx) {
        return 0 <= ny && ny < N && 0 <= nx && nx < M;
    }
}
