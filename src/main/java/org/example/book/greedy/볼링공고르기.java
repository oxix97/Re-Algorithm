package org.example.book.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 볼링공고르기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weight = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            weight[idx]++;
        }

        int answer = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = i + 1; j <= M; j++) {
                answer += weight[i] * weight[j];
            }
        }
        System.out.println(answer);
    }
}
