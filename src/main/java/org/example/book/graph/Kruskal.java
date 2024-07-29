
package org.example.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
 */
public class Kruskal {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] parent;
    static int sum = 0;
    static PriorityQueue<Edge> q;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) parent[i] = i;

        while (!q.isEmpty()) {
            Edge edge = q.poll();
            int a = edge.a;
            int b = edge.b;
            if (find(a) != find(b)) {
                union(a, b);
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
        parent = new int[N + 1];
        q = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            q.add(new Edge(a, b, cost));
        }
    }

    private static void output() {
        System.out.println(sum);
        for (int n : parent) {
            System.out.print(n+" ");
        }
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
