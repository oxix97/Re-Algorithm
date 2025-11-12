package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        long B = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] answer = recursion(A, B, N);
        for (int[] a1 : answer) {
            for (int a2 : a1) {
                System.out.print(a2 + " ");
            }
            System.out.println();
        }
    }

    private static int[][] recursion(int[][] A, long B, int N) {
        if (B == 1)
            return A;

        int[][] half = recursion(A, B / 2, N);

        if (B % 2 == 0) {
            return calculate(half, half, N);
        } else {
            return calculate(calculate(half, half, N), A, N);
        }
    }

    private static int[][] calculate(int[][] A, int[][] B, int N) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }
}
