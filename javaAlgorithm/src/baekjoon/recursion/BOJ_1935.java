package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        char[] tmp = br.readLine().toCharArray();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> st = new Stack<>();
        for (char c : tmp) {
            if ('A' <= c && c <= 'Z') {
                st.push((double) arr[c - 'A']);
            } else {
                double a = st.pop();
                double b = st.pop();
                st.push(calculate(b, a, c));
            }
        }

        System.out.printf("%.2f",st.pop());
    }

    private static double calculate(double a, double b, char op) {
        if (op == '+')
            return a + b;
        if (op == '-')
            return a - b;
        if (op == '*')
            return a * b;

        return a / b;
    }
}
