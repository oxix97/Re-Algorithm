package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> q;

    private static void inputs() throws IOException {
        q = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
    }

    private static void solution() {
        int sum = 0;
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            sum += (a + b);
            q.add(a + b);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
    }
}
