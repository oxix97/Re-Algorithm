package org.example.book.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class _1로만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int X;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        arr = new int[X + 1];
        for (int i = 2; i <= X; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) arr[i] = min(arr[i], arr[i / 2] + 1);
            else if (i % 3 == 0) arr[i] = min(arr[i], arr[i / 3] + 1);
            else if (i % 5 == 0) arr[i] = min(arr[i], arr[i / 5] + 1);
        }
        sb.append(arr[X]);
    }

    private static void inputs() throws IOException {
        X = Integer.parseInt(br.readLine());
    }

    private static void output() {
        System.out.println(sb);
    }
}
