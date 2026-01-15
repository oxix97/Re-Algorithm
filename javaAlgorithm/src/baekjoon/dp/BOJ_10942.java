package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] isPalindrome = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;

                if (arr[i] == arr[j] && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(isPalindrome[s][e] ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }
}
