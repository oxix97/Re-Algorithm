package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_GREEDY {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 1;
        while (a < b && b > 0) {
            if (b % 10 == 1)
                b /= 10;
            else if (b % 2 == 0)
                b /= 2;
            else
                break;
            cnt += 1;
        }

        if(a == b)
            System.out.println(cnt);
        else
            System.out.println(-1);
    }
}
