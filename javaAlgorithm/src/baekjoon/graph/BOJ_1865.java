package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int TC;
    static final int INF = -1 + Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<Node>[] A = new ArrayList[n + 1];
            for (int j = 0; j <= n; j++)
                A[j] = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                A[S].add(new Node(E, T));
                A[E].add(new Node(S, T));
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                A[S].add(new Node(E, -T));
            }

            boolean answer = solution(n, A);
            System.out.println(answer ? "YES" : "NO");
        }
    }

    private static boolean solution(int N, List<Node>[] arr) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int k = 1; k < N; k++) {
            boolean update = false;
            for (int i = 1; i <= N; i++) {
                for (Node node : arr[i]) {
                    if (dist[node.idx] > dist[i] + node.dist) {
                        dist[node.idx] = dist[i] + node.dist;
                        update = true;
                    }
                }
            }

            if (!update)
                break;
        }

        for (int i = 1; i <= N; i++) {
            for (Node node : arr[i]) {
                if (dist[node.idx] > dist[i] + node.dist)
                    return true;
            }
        }

        return false;
    }

    static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
