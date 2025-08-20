package programmers.kit.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class 아이템줍기 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] graph = new int[101][101];
        characterY *= 2;
        characterX *= 2;
        itemY *= 2;
        itemX *= 2;

        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int i = y1 + 1; i <= y2 - 1; i++) {
                for (int j = x1 + 1; j <= x2 - 1; j++) {
                    graph[i][j] = 2;
                }
            }

            for (int i = x1; i <= x2; i++) {
                if (graph[y1][i] == 0) {
                    graph[y1][i] = 1;
                }
                if (graph[y2][i] == 0) {
                    graph[y2][i] = 1;
                }
            }

            for (int i = y1; i <= y2; i++) {
                if (graph[i][x1] == 0) {
                    graph[i][x1] = 1;
                }
                if (graph[i][x2] == 0) {
                    graph[i][x2] = 1;
                }
            }
        }
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int[][] dist = new int[101][101];
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(characterY);
        q.addLast(characterX);

        while (!q.isEmpty()) {
            int y = q.removeFirst();
            int x = q.removeFirst();

            if (y == itemY && x == itemX) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (1 <= ny && ny <= 100 && 1 <= nx && nx <= 100 && graph[ny][nx] == 1 && dist[ny][nx] == 0) {
                    dist[ny][nx] = dist[y][x] + 1;
                    q.addLast(ny);
                    q.addLast(nx);
                }
            }
        }

        return dist[itemY][itemX] / 2;
    }
}
