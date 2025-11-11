package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2448 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        A = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++)
            Arrays.fill(A[i], ' ');

        draw(N, 0, N - 1);

        for (char[] a : A) {
            for (char b : a)
                sb.append(b);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void draw(int n, int r, int c) {
        if (n == 3) {
            A[r][c] = '*';
            A[r + 1][c - 1] = '*';
            A[r + 1][c + 1] = '*';
            Arrays.fill(A[r + 2], c - 2, c + 3, '*');
            return;
        }

        int len = n / 2;
        draw(len, r, c);
        draw(len, r + len, c - len);
        draw(len, r + len, c + len);
    }
}
