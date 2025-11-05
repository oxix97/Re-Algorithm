package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16953_BFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int answer = bfs(A, B);
        System.out.println(answer);
    }

    private static int bfs(long A, long B) {
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(A, 1));

        while (!q.isEmpty()) {
            Node node = q.removeFirst();
            long n = node.n;
            int cnt = node.cnt;

            if (n == B)
                return cnt;

            if (n * 2 <= B)
                q.addLast(new Node(n * 2, cnt + 1));

            if (1 + n * 10 <= B)
                q.addLast(new Node(1 + n * 10, cnt + 1));
        }

        return -1;
    }

    static class Node {
        long n;
        int cnt;

        public Node(long n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}
