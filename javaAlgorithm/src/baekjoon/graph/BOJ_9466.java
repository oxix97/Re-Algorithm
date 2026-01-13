package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class BOJ_9466 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static int[] stu;
    static boolean[] visit;
    static boolean[] finished;
    static int count;
    //    자기 자신을 선택하는것과 사이클 여부를 확인하여 팀에 속하지 못한 학생 수를 구하는 문제
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            stu = new int[n + 1];
            visit = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                stu[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!visit[j])
                    dfs(j);
            }
            sb.append(n - count).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int now) {
        visit[now] = true;
        int next = stu[now];

        if (!visit[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                count += 1;
                while (next != now) {
                    next = stu[next];
                    count += 1;
                }
            }
        }

        finished[now] = true;
    }
}
