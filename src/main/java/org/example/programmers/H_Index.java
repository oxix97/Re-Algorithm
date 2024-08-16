package org.example.programmers;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = solution(citations);
        System.out.println(answer);
    }
    public static int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return 0;
    }
}
