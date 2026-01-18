package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String A, B;

    public static void main(String[] args) throws IOException {
        A = br.readLine();
        B = br.readLine();

        int al = A.length();
        int bl = B.length();

        int[][] dp = new int[al + 1][bl + 1];

        for (int i = 1; i <= al; i++) {
            for (int j = 1; j <= bl; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[al][bl]);
    }
}
