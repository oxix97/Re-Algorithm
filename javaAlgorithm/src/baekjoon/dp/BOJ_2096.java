package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] max_sum = new int[N][3];
        int[][] min_sum = new int[N][3];
        for (int i = 0; i < 3; i++) {
            max_sum[0][i] = A[0][i];
            min_sum[0][i] = A[0][i];
        }

        for (int i = 1; i < N; i++) {
            max_sum[i][0] = Math.max(max_sum[i - 1][0], max_sum[i - 1][1]) + A[i][0];
            max_sum[i][1] = Math.max(Math.max(max_sum[i - 1][0], max_sum[i - 1][1]), max_sum[i - 1][2]) + A[i][1];
            max_sum[i][2] = Math.max(max_sum[i - 1][1], max_sum[i - 1][2]) + A[i][2];

            min_sum[i][0] = Math.min(min_sum[i - 1][0], min_sum[i - 1][1]) + A[i][0];
            min_sum[i][1] = Math.min(Math.min(min_sum[i - 1][0], min_sum[i - 1][1]), min_sum[i - 1][2]) + A[i][1];
            min_sum[i][2] = Math.min(min_sum[i - 1][1], min_sum[i - 1][2]) + A[i][2];
        }

        int max_result = Math.max(Math.max(max_sum[N - 1][0], max_sum[N - 1][1]), max_sum[N - 1][2]);
        int min_result = Math.min(Math.min(min_sum[N - 1][0], min_sum[N - 1][1]), min_sum[N - 1][2]);

        System.out.println(max_result + " " + min_result);
    }
}
