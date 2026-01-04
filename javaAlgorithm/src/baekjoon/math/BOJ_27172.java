package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27172 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] num, score;
    static boolean[] card;
    static final int MAX_VALUE = 1_000_000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        card = new boolean[MAX_VALUE + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            card[num[i]] = true;
        }

        score = new int[MAX_VALUE + 1];

        for (int n : num) {
            for (int i = n * 2; i <= MAX_VALUE; i += n) {
                if (card[i]) {
                    score[n] += 1;
                    score[i] -= 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : num) {
            sb.append(score[n]).append(' ');
        }

        System.out.println(sb);
    }
}
