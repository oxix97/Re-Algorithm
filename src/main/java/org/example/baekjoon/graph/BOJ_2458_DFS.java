package org.example.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458_DFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 1) {
                    dfs(i, j);
                }
            }
        }
    }

    private static void dfs(int y, int x) {
        visited[x] = true;
        result[y][x] = 1;
        result[x][y] = 1;

        for (int i = 1; i <= N; i++) {
            if (graph[x][i] == 1 && !visited[i]) dfs(y, i);
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        result = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
    }

    private static void output() {
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if(result[i][j] == 1) ++count;
            }
            if(count==N-1) ++answer;
        }
        sb.append(answer);
        System.out.println(sb);
    }
}
