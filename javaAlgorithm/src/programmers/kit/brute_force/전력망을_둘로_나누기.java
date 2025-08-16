package programmers.kit.brute_force;

import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기 {
    List<Integer>[] tree;
    boolean[] visit;

    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            tree[v1].add(v2);
            tree[v2].add(v1);
        }
        int answer = 1000;
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            tree[v1].remove(Integer.valueOf(v2));
            tree[v2].remove(Integer.valueOf(v1));

            int a = dfs(v1);
            int b = n - a;

            answer = Math.min(answer, Math.abs(a - b));

            tree[v1].add(v2);
            tree[v2].add(v1);
        }

        return answer;
    }

    private int dfs(int n) {
        int cnt = 1;
        visit[n] = true;

        for (int next : tree[n]) {
            if (!visit[next]) {
                cnt += dfs(next);
            }
        }
        visit[n] = false;
        return cnt;
    }
}

