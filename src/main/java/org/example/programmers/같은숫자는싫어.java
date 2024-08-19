package org.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);

        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] != arr[i]) q.add(arr[i]);

        int idx = 0;
        int[] answer = new int[q.size()];

        while (!q.isEmpty()) answer[idx++] = q.poll();
        return answer;
    }

    public static void main(String[] args) {

    }
}
