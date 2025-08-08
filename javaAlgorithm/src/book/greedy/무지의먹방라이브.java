package book.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 무지의먹방라이브 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] food_times = {3, 1, 2};
        int answer = solution2(food_times, 5);
        System.out.println(answer);
    }

    public static int solution2(int[] food_times, long k) {
        // 총 음식 시간을 계산하여 만약 k보다 작으면 -1 반환
        long sum = Arrays.stream(food_times).sum();
        if (sum <= k) return -1;

        PriorityQueue<Food> q = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            q.add(new Food(i + 1, food_times[i]));
        }

        while (!q.isEmpty()) {
            if (k-- == 0) break;
            
        }

        while (!q.isEmpty()) {
            if (k-- == 0) break;

            Food food = q.poll();
            if (food.time - 1 > 0)
                q.add(new Food(food.n, food.time - 1));
        }

        if (q.isEmpty()) return -1;

        return q.poll().n;
    }

    public static int solution(int[] food_times, long k) {
        int idx = 0;
        int count = 0;
        while (k-- != 0) {
            while (food_times[idx] == 0) {
                idx = (idx + 1) % food_times.length;
                ++count;
                if (count == food_times.length) {
                    return -1;
                }
            }
            food_times[idx] -= 1;
            idx = (idx + 1) % food_times.length;
            count = 0;
        }

        return (idx % food_times.length) + 1;
    }

    static class Food implements Comparable<Food> {
        int n;
        int time;

        public Food(int n, int time) {
            this.n = n;
            this.time = time;
        }

        @Override
        public int compareTo(Food o) {
            return o.time - this.time;
        }
    }
}
