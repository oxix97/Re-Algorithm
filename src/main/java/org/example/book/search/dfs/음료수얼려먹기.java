package org.example.book.search.dfs;

import java.io.IOException;

public class 음료수얼려먹기 {
    public static void main(String[] args) throws IOException {
        //input
        int n1 = 4;
        int m1 = 5;
        int[][] arr1 = {
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int n2 = 15;
        int m2 = 14;
        int[][] arr2 = {
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
        };

        solution(n1, m1, arr1);
        solution(n2, m2, arr2);
    }

    public static void solution(int n, int m, int[][] arr) {
        boolean[][] visited = new boolean[n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || arr[i][j] == 1) continue;
                dfs(i, j, n, m, arr, visited);
                ++answer;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int y, int x, int n, int m, int[][] arr, boolean[][] visited) {
        visited[y][x] = true;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (outOfRange(ny, nx, n, m) || visited[ny][nx] || arr[ny][nx] == 1) continue;
            dfs(ny, nx,n,m,arr, visited);
        }
    }

    private static boolean outOfRange(int y, int x, int n, int m) {
        return y < 0 || x < 0 || y >= n || x >= m;
    }
}
