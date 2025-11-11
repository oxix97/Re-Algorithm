package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int R;
    static int C;
    static int score = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);

        recursion(len, 0, 0);
    }

    private static void recursion(int n, int r, int c) {
        if (n == 1) {
            System.out.println(score);
            return;
        }

        int half = n / 2;
        int size = half * half;

        if (r + half > R && c + half > C) {
            recursion(half, r, c);
        } else if (r + half > R && c + half <= C) {
            score += size;
            recursion(half, r, c + half);
        } else if (r + half <= R && c + half > C) {
            score += size * 2;
            recursion(half, r + half, c);
        } else {
            score += size * 3;
            recursion(half, r + half, c + half);
        }
    }
}
