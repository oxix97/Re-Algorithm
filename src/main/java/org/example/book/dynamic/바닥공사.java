package org.example.book.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바닥공사 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 796796;
        }
        sb.append(dp[N]);
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    private static void output() {
        System.out.println(sb);
    }
}
