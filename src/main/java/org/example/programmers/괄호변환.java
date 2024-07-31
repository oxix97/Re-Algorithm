package org.example.programmers;

import java.util.Stack;

public class 괄호변환 {
    public static void main(String[] args) {
        String a1 = solution("(()())()");
        String a2 = solution(")(");
        String a3 = solution("()))((()");

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
    }

    private static String solution(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (w.isEmpty()) return w;

        int left = 0;
        int right = 0;
        int mid = 0;

        // 2. 최소한의 균형 잡힌 문자열 탐색
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') left++;
            else right++;

            if (left == right) {
                mid = i;
                break;
            }
        }
        String u = w.substring(0, mid + 1);
        String v = w.substring(mid + 1);

        // 3. 올바른 문자열인 경우
        if (isCheck(u)) return u + solution(v);

        // 4. 올바른 문자열이 아닌 경우
        return '(' + solution(v) + ')' + reverse(u.substring(1, u.length() - 1));
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }

    private static boolean isCheck(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') s.push(c);
            else {
                if (s.isEmpty()) return false;
                s.pop();
            }
        }
        return s.isEmpty();
    }
}
