package org.example.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
3 2 1
1 2 4
1 3 2
답 : 2 4
 */
public class 전보 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, C;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> q;
    static int[] dist;
    static final int INF = 999_999_999;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        //1. 시작 지점 초기화
        dist[C] = 0;

        //2. 우선순위 큐 초기화
        q = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        q.add(new Node(C, 0));

        //3. 현재 노드에서 최단거리의 노드를 꺼내 방문 처리
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (dist[now.v] < now.cost) continue;

            //4. 방문하지 않고 다른 노드를 거쳐 가는 경우가 더 짧은 경우
            for (Node next : graph[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, z));
        }

        Arrays.fill(dist, INF);
    }

    private static void output() {
        int count = 0;
        int max = 0;
        for (int i = 1; i <= N; i++)
            if (dist[i] < INF) ++count;

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i]);
        }

        sb.append(count - 1).append(' ').append(max);
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
