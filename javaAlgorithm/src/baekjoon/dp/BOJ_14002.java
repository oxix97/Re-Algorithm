package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int last = 0;
        int[] dp = new int[N + 1];
        int[] parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                last = i;
            }
        }

        System.out.println(max);

        int i = last;
        Stack<Integer> q = new Stack<>();
        while (i != 0) {
            q.push(A[i]);
            i = parent[i];
        }

        while (!q.isEmpty()) {
            System.out.print(q.pop() + " ");
        }
    }
}
