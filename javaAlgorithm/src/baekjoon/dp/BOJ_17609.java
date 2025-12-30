package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int result = solv(s);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static int solv(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right))
                    return 1;
                return 2;
            }
            left += 1;
            right -= 1;
        }

        return 0;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }

        return true;
    }
}
