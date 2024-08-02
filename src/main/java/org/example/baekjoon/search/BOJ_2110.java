package org.example.baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, C;
    static long[] arr;

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
    }

    private static void solution() {
        Arrays.sort(arr);
        long min_dist = 1;
        long max_dist = arr[N - 1] - arr[0];

        while (min_dist <= max_dist) {
            long mid_dist = (min_dist + max_dist) / 2;
            if (count(mid_dist) < C) {
                max_dist = mid_dist - 1;
            } else {
                min_dist = mid_dist + 1;
            }
        }
        sb.append(max_dist);
    }

    private static int count(long dist) {
        int cnt = 1;
        long last = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - last >= dist) {
                cnt++;
                last = arr[i];
            }
        }
        return cnt;
    }

    private static void output() {
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }
}
