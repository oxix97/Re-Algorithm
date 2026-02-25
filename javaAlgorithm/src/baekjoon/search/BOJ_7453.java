package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BOJ_7453 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] A, B, C, D;
    static int[] AB, CD;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        AB = new int[N * N];
        CD = new int[N * N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(CD);

        long answer = 0;

        for (int a : AB) {
            int left = binarySearchLeft(-a);
            int right = binarySearchRight(-a);
            answer += right - left;
        }

        System.out.println(answer);
    }

    private static int binarySearchLeft(int target) {
        int left = 0;
        int right = CD.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (CD[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int binarySearchRight(int target) {
        int left = 0;
        int right = CD.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (CD[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
