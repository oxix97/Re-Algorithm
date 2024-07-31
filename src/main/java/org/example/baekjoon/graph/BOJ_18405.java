package org.example.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K, S, X, Y;
    static int[][] graph;
    static boolean[][] visited;
    static PriorityQueue<Virus> q;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        q = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] != 0) q.add(new Virus(i, j, graph[i][j], 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

    }

    private static void solution() {
        int time = 0;
        while (!q.isEmpty() && time < S) {
            int size = q.size(); // 초기 사이즈
            for (int i = 0; i < size; i++) {
                Virus v = q.poll();
                int y = v.y;
                int x = v.x;

                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (rangeException(ny, nx)) continue;

                    if (!visited[ny][nx] && graph[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        graph[ny][nx] = v.num;
                        q.add(new Virus(ny, nx, graph[ny][nx], time + 1));
                    }
                }
            }
            ++time;
        }
        System.out.println(graph[Y][X]);
    }

    private static boolean rangeException(int y, int x) {
        return y < 1 || x < 1 || y > N || x > N;
    }


    private static void output() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    static class Virus implements Comparable<Virus> {
        int y, x;

        public Virus(int y, int x, int num, int time) {
            this.y = y;
            this.x = x;
            this.num = num;
            this.time = time;
        }

        int num;
        int time;

        @Override
        public int compareTo(Virus o) {
            if (this.time == o.time) {
                return this.num - o.num;
            }
            return this.time - o.time;
        }
    }
}
