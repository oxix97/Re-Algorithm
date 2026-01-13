package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        for (char c : br.readLine().toCharArray()) {
            if ('A' <= c && c <= 'Z')
                sb.append(c);
            else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(')
                    sb.append(s.pop());
                if (!s.isEmpty())
                    s.pop();
            } else {
                while (!s.isEmpty() && priority(s.peek()) >= priority(c)) {
                    sb.append(s.pop());
                }
                s.push(c);
            }
        }

        while (!s.isEmpty())
            sb.append(s.pop());

        System.out.println(sb);
    }

    private static int priority(char op) {
        if (op == '*' || op == '/')
            return 2;
        if (op == '+' || op == '-')
            return 1;
        return 0;
    }
}
