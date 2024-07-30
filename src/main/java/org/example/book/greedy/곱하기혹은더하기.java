package org.example.book.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 곱하기혹은더하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        int sum = 0;
        for (int n : arr) {
            if (n == 0) continue;
            if (sum == 0) {
                sum += n;
            } else {
                sum *= n;
            }
        }
        System.out.println(sum);
    }

    private static void inputs() throws IOException {
        arr = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void output() {

    }
}
