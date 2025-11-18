package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13172 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M;
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        M = Integer.parseInt(br.readLine());
        long answer = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());
            long C = gcd(N, S);
            N /= C;
            S /= C;

            long modular = power(N,MOD - 2);

            long term = (S * modular) % MOD;
            answer = (answer + term) % MOD;

        }

        System.out.println(answer);
    }

    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static long power(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
}
