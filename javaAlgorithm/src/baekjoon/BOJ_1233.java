package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1233 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int S1, S2, S3;
    static int[] score = new int[81];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        S1 = Integer.parseInt(st.nextToken());
        S2 = Integer.parseInt(st.nextToken());
        S3 = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    score[i + j + k] += 1;
                }
            }
        }
        int answer = 0;
        int cnt = -1;
        for(int i=2;i<=80;i++){
            if (score[i] > cnt) {
                cnt = score[i];
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
