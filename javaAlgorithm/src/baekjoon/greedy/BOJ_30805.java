package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_30805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] A, B;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        recursion();

        System.out.println(result.size());
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    private static void recursion() {
        int idxA = 0;
        int idxB = 0;

        while (true) {
            int max = -1;
            int tmpA = -1;
            int tmpB = -1;

            for (int i = idxA; i < N; i++) {
                for (int j = idxB; j < M; j++) {
                    if (A[i] == B[j] && A[i] > max) {
                        tmpA = i;
                        tmpB = j;
                        max = A[i];
                    }
                }
            }

            if (max == -1)
                break;

            result.add(max);

            idxA = tmpA + 1;
            idxB = tmpB + 1;
        }
    }
}
