package org.example.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_30804 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solution() {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < N; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}