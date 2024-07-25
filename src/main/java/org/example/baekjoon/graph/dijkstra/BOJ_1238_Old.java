package org.example.baekjoon.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_Old {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> q;
    static int[] party;
    static int[] home;
    static final int INF = 999_999_999;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        // X에서 다른 모든 마을로 가는 최단 경로 계산
        dijkstra(home, X);

        // 다른 모든 마을에서 X로 가는 최단 경로 계산
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                party[i] = dijkstra(new int[N + 1], i);
            }
        }
    }

    private static int dijkstra(int[] dist, int idx) {
        Arrays.fill(dist, INF);
        dist[idx] = 0;
        q = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        q.add(new Node(idx, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (dist[now.v] < now.cost) continue;

            for (Node next : graph[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[X];
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        party = new int[N + 1];
        home = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
        }
    }

    private static void output() {
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, party[i] + home[i]);
        }
        System.out.println(max);
    }

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
