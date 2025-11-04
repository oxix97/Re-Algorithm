package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] A;
    static int N;
    static int M;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        recursion(0, new StringBuilder());
    }

    private static void recursion(int idx, StringBuilder sb) {
        if (idx == M) {
            System.out.println(sb);
            return;
        }

        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (prev == A[i] || visit[i])
                continue;

            int len = sb.length();
            sb.append(A[i]).append(' ');
            visit[i] = true;
            prev = A[i];

            recursion(idx + 1, sb);

            visit[i] = false;
            sb.setLength(len);
        }
    }
}
