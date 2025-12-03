package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, dist));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            boolean update = false;
            for (Edge e : edges) {
                if (dist[e.start] != INF && dist[e.end] > dist[e.start] + e.cost) {
                    dist[e.end] = dist[e.start] + e.cost;
                    update = true;
                }
            }
            if (!update)
                break;
        }

        boolean cycle = false;
        for (Edge e : edges) {
            if (dist[e.start] != INF && dist[e.end] > dist[e.start] + e.cost) {
                cycle = true;
                break;
            }
        }

        if (cycle) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF)
                    sb.append(-1);
                else
                    sb.append(dist[i]);
                sb.append('\n');
            }
            System.out.println(sb);
        }
    }

    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
