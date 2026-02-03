package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BOJ_20303 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] child, parent, sum, group;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        child = new int[N + 1];
        parent = new int[N + 1];
        sum = new int[N + 1];
        group = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            child[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
            group[i] = 1;
            sum[i] = child[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int[] dp = new int[K];
        for (int i = 1; i <= N; i++) {
            if (parent[i] != i) continue;

            for (int j = K - 1; j >= group[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - group[i]] + sum[i]);
            }
        }

        System.out.println(dp[K - 1]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)
            return;

        if (a < b) {
            parent[b] = a;
            group[a] += group[b];
            sum[a] += sum[b];
        } else {
            parent[a] = b;
            group[b] += group[a];
            sum[b] += sum[a];
        }
    }

    private static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
