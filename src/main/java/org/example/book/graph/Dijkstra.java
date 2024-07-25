package org.example.book.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int start;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> q;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        //1. 시작지점 초기화
        distance[start] = 0;

        //2. 우선순위 큐 초기화
        q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));

        //3. 현재 최단 거리가 가장 짧은 노드를 꺼내 방문 처리
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
            }

            //4. 방문하지 않고, 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
            for (Node next : graph[now.v]) {
                if (visited[next.v]) continue;
                if (distance[next.v] <= now.cost + next.cost) continue;

                distance[next.v] = now.cost + next.cost;
                q.add(new Node(next.v, distance[next.v]));
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }
    }

    private static void output() {
        for (int i = 1; i <= N; i++) {
            sb.append(i == Integer.MAX_VALUE ? "INFINITY" : distance[i]).append('\n');
        }
        System.out.println(sb);
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
