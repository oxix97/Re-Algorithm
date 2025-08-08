package book.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static final int NONE = 10001;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        int[] dp = new int[M + 1];
        Arrays.fill(dp, NONE);
        dp[0] = 0;

        for (int n : arr) {
            for (int i = 1; i <= M; i++) {
                if (i - n >= 0 && dp[i - n] != NONE)
                    dp[i] = Math.min(dp[i], dp[i - n] + 1);
            }
        }
        sb.append(dp[M] == NONE ? -1 : dp[M]);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void output() {
        System.out.println(sb);
    }
}
