package org.example.book.greedy;

import java.util.Arrays;

public class 숫자카드게임 {
    public static void main(String []args) {
        //input
        int n1 = 3;
        int m1 = 3;
        int[][] arr1 = {
                {3,1,2},
                {4,1,4},
                {2,2,2}
        };

        int n2 = 2;
        int m2 = 4;
        int[][] arr2 = {
                {7,3,1,8},
                {3,3,3,4}
        };

        solution(n1,m1,arr1);
        solution(n2,m2,arr2);
    }

    private static void solution(int n, int m, int[][] arr){
        for (int[] ints : arr) Arrays.sort(ints);
        int max = 0;
        for (int[] ints : arr) {
            max = Math.max(max, ints[0]);
        }
        System.out.println(max);
    }
}
