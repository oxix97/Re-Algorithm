package org.example.programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class 삼각_달팽이 {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int ny = -1;
        int nx = 0;
        int v = 1;

        while (n > 0) {

            for (int i = 0; i < n; i++) {
                arr[++ny][nx] = v++;
            }
            --n;

            for (int i = 0; i < n; i++) {
                arr[ny][++nx] = v++;
            }
            --n;

            for (int i = 0; i < n; i++) {
                arr[--ny][--nx] = v++;
            }
            --n;
        }

        List<Integer> list = new ArrayList<>();

        for (int[] ar : arr) {
            for (int a : ar) {
                if (a == 0) continue;
                list.add(a);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
