package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        int[] time = new int[100_001];
        int[] cnt = new int[100_001];

        time[N] = 1;
        cnt[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : getNext(now)) {
                if (0 <= next && next <= 100_000) {
                    if (time[next] == 0) {
                        q.add(next);
                        time[next] = time[now] + 1;
                        cnt[next] = cnt[now];
                    } else if (time[next] == time[now] + 1) {
                        cnt[next] += cnt[now];
                    }
                }
            }
        }

        System.out.println(time[K] - 1);
        System.out.println(cnt[K]);
    }

    private static int[] getNext(int idx) {
        return new int[]{idx - 1, idx + 1, idx * 2};
    }
}
