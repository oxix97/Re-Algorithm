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
//        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (w.isEmpty()) return w;

        int left = 0;
        int right = 0;
        int mid = 0;

//        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
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

//        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if (isCheck(u)) return u + solution(v);

//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//        4-3. ')'를 다시 붙입니다.
//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//        4-5. 생성된 문자열을 반환합니다.
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
