package org.example.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int max = -1_000_000_001;
    static int min = 1_000_000_001;
    static int[] arr;
    static int[] operator = new int[4]; // +, -, *, /

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solution() {
        recursion(1, arr[0]);
    }

    private static void recursion(int idx, int v) {
        if (idx == N) {
            max = Math.max(max, v);
            min = Math.min(min, v);
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                int value = calculator(i, v, arr[idx]);
                recursion(idx + 1, value);
                operator[i]++;
            }
        }
    }

    private static int calculator(int idx, int a, int b) {
        if (idx == 0) return a + b;
        if (idx == 1) return a - b;
        if (idx == 2) return a * b;

        return a / b;
    }

    private static void output() {
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }
}
