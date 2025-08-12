package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1058 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] friends;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        friends = new char[N][N];
        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().toCharArray();
        }
        int max_count = 0;
        for (int i = 0; i < N; i++) {
            Deque<Integer> q = new ArrayDeque<>();
            dist = new int[N];
            visit = new boolean[N];
            q.add(i);
            dist[i] = 0;
            visit[i] = true;

            while (!q.isEmpty()) {
                int u = q.removeFirst();

                for (int v = 0; v < N; v++) {
                    if (friends[u][v] == 'Y' && !visit[v]) {
                        q.addLast(v);
                        visit[v] = true;
                        dist[v] = dist[u] + 1;
                    }
                }
            }
            int count = 0;
            for (int j = 0; j < N; j++) {
                if(dist[j] >= 1 && dist[j] < 3){
                    count += 1;
                }
            }
            max_count = Math.max(max_count,count);
        }
        System.out.println(max_count);
    }
}
