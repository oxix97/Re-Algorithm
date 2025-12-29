package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] puzzle;
    static List<int[]> zeros;
    static int N;

    public static void main(String[] args) throws IOException {
        puzzle = new int[9][9];
        zeros = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = Integer.parseInt(s[j]);
                if (puzzle[i][j] == 0)
                    zeros.add(new int[]{i, j});
            }
        }

        N = zeros.size();
        recursion(0);
    }

    private static void recursion(int idx) {
        if (idx == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(puzzle[i][j]);
                }
                sb.append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }

        int[] t = zeros.get(idx);
        int y = t[0];
        int x = t[1];
        for (int i = 1; i <= 9; i++) {
            if (access(y, x, i)) {
                puzzle[y][x] = i;
                recursion(idx + 1);
                puzzle[y][x] = 0;
            }
        }
    }

    private static boolean access(int y, int x, int target) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[y][i] == target || puzzle[i][x] == target)
                return false;
        }

        int startY = (y / 3) * 3;
        int startX = (x / 3) * 3;

        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (puzzle[i][j] == target) {
                    return false;
                }
            }
        }

        return true;
    }
}