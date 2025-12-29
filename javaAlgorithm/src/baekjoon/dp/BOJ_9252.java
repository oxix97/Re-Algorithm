package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s1;
    static String s2;
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        s1 = br.readLine();
        s2 = br.readLine();
        N = s1.length();
        M = s2.length();

        dp = new int[N + 1][M + 1];

        int len = getLcsLength();
        System.out.println(len);

        if (len == 0)
            return;

        String answer = getLcsValue();
        System.out.println(answer);
    }

    private static int getLcsLength() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[N][M];
    }

    private static String getLcsValue() {
        StringBuilder sb = new StringBuilder();
        int i = N;
        int j = M;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] == dp[i][j]) {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }
}
