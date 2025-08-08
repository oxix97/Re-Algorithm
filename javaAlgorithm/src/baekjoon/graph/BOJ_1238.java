package baekjoon.graph;

import java.io.*;
import java.util.*;

public class BOJ_1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, X;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverseGraph;
    static int[] toParty;
    static int[] toHome;
    static final int INF = 999_999_999;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        // X에서 다른 모든 마을로 가는 최단 경로 계산
        toHome = dijkstra(graph, X);
        
        // 다른 모든 마을에서 X로 가는 최단 경로 계산
        toParty = dijkstra(reverseGraph, X);
    }

    private static int[] dijkstra(ArrayList<Node>[] g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (dist[now.v] < now.cost) continue;

            for (Node next : g[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        return dist;
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
            reverseGraph[b].add(new Node(a, cost));
        }
    }

    private static void output() {
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                max = Math.max(max, toParty[i] + toHome[i]);
            }
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