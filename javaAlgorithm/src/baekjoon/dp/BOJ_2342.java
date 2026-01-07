package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2342 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int INF = -1 + Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        List<Integer> cmd = new ArrayList<>();
        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            cmd.add(n);
        }

        int[][][] dp = new int[cmd.size() + 1][5][5];
        for (int i = 0; i <= cmd.size(); i++) {
            for (int j = 0; j <= 4; j++)
                Arrays.fill(dp[i][j], INF);
        }

        dp[0][0][0] = 0;

        for (int k = 1; k <= cmd.size(); k++) {
            int target = cmd.get(k - 1);
            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (dp[k - 1][i][j] != INF) {
                        dp[k][target][j] = Math.min(dp[k][target][j], dp[k - 1][i][j] + move(i, target));
                        dp[k][i][target] = Math.min(dp[k][i][target], dp[k - 1][i][j] + move(j, target));
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                answer = Math.min(answer, dp[cmd.size()][i][j]);
            }
        }

        System.out.println(answer);
    }

    private static int move(int start, int end) {
        if (start == end)
            return 1;
        if (start == 0)
            return 2;
        if (Math.abs(end - start) == 2)
            return 4;
        return 3;
    }
}
