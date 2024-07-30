package org.example.book.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
K1KA5CB7 -> ABCKK13
AJKDLSI412K4JSJ9D -> ADDIJJJKKLSS20
 */
public class 문자열재정렬 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] cmd = br.readLine().toCharArray();
        int sum = 0;
        Arrays.sort(cmd);
        for (char c : cmd) {
            if (Character.isDigit(c)) sum += c - '0';
            else sb.append(c);
        }
        sb.append(sum);
        System.out.println(sb);
    }
}
