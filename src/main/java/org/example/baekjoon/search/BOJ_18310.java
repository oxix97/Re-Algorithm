package org.example.baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18310 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solution() {
        int answer = Arrays.stream(arr).sorted().toArray()[(N - 1) / 2];
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }
}