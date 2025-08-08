package book.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UnionFind_PrintUnion {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static Queue<Integer> q;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        while (!q.isEmpty()) {
            int a = q.poll();
            int b = q.poll();

            union(a,b);
        }
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1];
        q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            graph[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            q.add(a);
            q.add(b);
        }
    }

    private static void union(int a, int b) {
        // MEMO : 두 원소가 속한 집합을 합치기
        a = find(a);
        b = find(b);
        if (a < b) graph[b] = a;
        else graph[a] = b;
    }

    private static int find(int n) {
        // MEMO : 루트 노트가 아니면 루트 노드를 찾을 때까지 재귀적으로 호출
        if (graph[n] != n) graph[n] = find(graph[n]);
        return graph[n];
    }

    private static void output() {
        for (int i = 1; i <= N; i++) {
            sb.append(find(graph[i])).append(' ');
        }
        System.out.println(sb);
    }
}
