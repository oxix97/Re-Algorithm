package baekjoon.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_9084 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            coin = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                coin[j] = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());

            int answer = solv();
            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }

    private static int solv() {
        int[] dp = new int[M + 1];
        dp[0] = 1;

        for (int c : coin) {
            for (int i = c; i <= M; i++) {
                dp[i] += dp[i - c];
            }
        }

        return dp[M];
    }
}