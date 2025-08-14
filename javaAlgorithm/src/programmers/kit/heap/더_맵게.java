package programmers.kit.heap;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville) {
            pq.add(n);
        }
        int answer = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            if (a >= K) {
                break;
            }
            int b = pq.poll() * 2;
            pq.add(a + b);
            answer += 1;
        }

        if (pq.poll() < K) {
            return -1;
        }
        return answer;
    }
}
