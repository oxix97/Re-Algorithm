package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][] arr = {{1, 1}, {1, 0}};
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        long[][] answer = recursion(arr, n - 1);
        System.out.println(answer[0][0]);
    }

    private static long[][] recursion(long[][] arr, long n) {
        if (n == 1) {
            return arr;
        }

        long[][] tmp = recursion(arr, n / 2);

        tmp = calculate(tmp, tmp);

        if (n % 2 == 1) {
            return calculate(tmp, arr);
        }

        return tmp;
    }

    private static long[][] calculate(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}
