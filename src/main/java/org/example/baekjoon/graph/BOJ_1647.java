package org.example.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] parent;
    static int last = 0;
    static int sum = 0;
    static PriorityQueue<Edge> q;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        while (!q.isEmpty()) {
            Edge edge = q.poll();
            int a = edge.a;
            int b = edge.b;
            if (find(a) != find(b)) {
                union(a, b);
                last = Math.max(last, edge.cost);
                sum += edge.cost;
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int find(int n) {
        if (parent[n] != n) parent[n] = find(parent[n]);
        return parent[n];
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        q = new PriorityQueue<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            q.add(new Edge(a, b, cost));
        }
    }

    private static void output() {
        System.out.println(sum - last);
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
