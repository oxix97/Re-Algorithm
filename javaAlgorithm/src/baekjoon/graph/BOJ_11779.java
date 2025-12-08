package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static final int INF = -1 + Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        List<Bus>[] edges = new List[N + 1];
        for (int i = 0; i <= N; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[start].add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Bus> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Bus(start, 0));

        int[] path = new int[N + 1];
        while (!q.isEmpty()) {
            Bus now = q.poll();

            if (now.cost > dist[now.pos])
                continue;

            for (Bus next : edges[now.pos]) {
                if (dist[now.pos] + next.cost < dist[next.pos]) {
                    dist[next.pos] = dist[now.pos] + next.cost;
                    path[next.pos] = now.pos;
                    q.add(new Bus(next.pos, dist[next.pos]));
                }
            }
        }

        System.out.println(dist[end]);

        List<Integer> list = new ArrayList<>();
        int tmp = end;
        while (tmp != 0) {
            list.add(tmp);
            tmp = path[tmp];
        }
        Collections.reverse(list);

        System.out.println(list.size());
        for (int n : list) {
            System.out.print(n+ " ");
        }

    }

    static class Bus {
        int pos;
        int cost;

        public Bus(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }

    }
}
