package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int left = 0, right = 0;
        for (int i = 0; i < arr.length / 2; i++) left += arr[i];
        for (int i = arr.length / 2; i < arr.length; i++) right += arr[i];

        if (left == right) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
