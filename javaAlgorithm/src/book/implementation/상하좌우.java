package book.implementation;

import java.util.HashMap;
import java.util.Map;

public class 상하좌우 {
    public static void main(String[] args) {
        //input
        int N = 5;
        String[] command = {"R", "R", "R", "U", "D", "D"};

        solution(N, command);
    }

    private static void solution(int n, String[] command) {
        StringBuilder sb  = new StringBuilder();
        //시작지점 1,1
        int[][] arr = new int[n + 1][n + 1];
        int y = 1;
        int x = 1;
        Map<String, int[]> map = new HashMap<>();
        map.put("L", new int[]{0, -1});
        map.put("R", new int[]{0, 1});
        map.put("U", new int[]{-1, 0});
        map.put("D", new int[]{1, 0});

        for (String cmd : command) {
            int[] move = map.get(cmd);
            int ny = y + move[0];
            int nx = x + move[1];
            if (outOfRange(ny, nx, n)) continue;
            y = ny;
            x = nx;
        }
        sb.append(y).append(' ').append(x);
        System.out.println(sb);
    }

    private static boolean outOfRange(int ny, int nx, int n) {
        return ny > n || nx > n || ny < 1 || nx < 1;
    }
}
