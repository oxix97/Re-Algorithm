package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2166 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static List<int[]> t;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        t = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            t.add(new int[]{y, x});
        }

        t.add(t.get(0));

        long s1 = 0;
        long s2 = 0;
        for (int i = 0; i < N; i++) {
            int[] a = t.get(i);
            int[] b = t.get(i + 1);

            s1 += (long) a[0] * b[1];
            s2 += (long) a[1] * b[0];
        }

        double result = (double) Math.abs(s1 - s2) / 2;
        System.out.printf("%.1f", result);
    }
}
