package org.example.book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */
public class 커리큘럼 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] indegree;
    static int[] cost;
    static int[] result;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                result[i] = cost[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                    result[next] = Math.max(result[next], result[now] + cost[next]);
                }
            }
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        result = new int[N + 1];
        cost = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            cost[i] = t;

            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) break;
                graph[n].add(i);
                ++indegree[i];
            }
        }
    }

    private static void output() {
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }
}
