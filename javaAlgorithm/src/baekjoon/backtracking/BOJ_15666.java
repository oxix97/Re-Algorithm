package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_15666 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> A;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            set.add(Integer.parseInt(st.nextToken()));

        A = set.stream().sorted()
                .collect(Collectors.toList());

        recursion(0, 0, new StringBuilder());
    }

    private static void recursion(int start, int depth, StringBuilder sb) {
        if (depth == M) {
            System.out.println(sb);
            return;
        }

        for (int i = start; i < A.size(); i++) {
            int len = sb.length();
            sb.append(A.get(i)).append(' ');
            recursion(i, depth + 1, sb);
            sb.setLength(len);
        }
    }
}
