package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        long answer = recursion(A, B, C);
        System.out.println(answer);
    }

    private static long recursion(long a, long b, long c) {
        if (b == 1)
            return a % c;

        long tmp = recursion(a, b / 2, c);

        if (b % 2 == 0)
            return (tmp * tmp) % c;

        return (tmp % c * tmp % c * a % c) % c;
    }
}
