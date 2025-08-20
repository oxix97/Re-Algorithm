package programmers.kit.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class 게임_맵_최단거리 {
    public int solution(int[][] maps) {
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        int m = maps.length;
        int n = maps[0].length;

        int[][] dist = new int[m + 1][n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        dist[1][1] = 1;
        q.addLast(1);
        q.addLast(1);

        while(!q.isEmpty()){
            int y = q.removeFirst();
            int x = q.removeFirst();

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(1<= ny && ny <= m && 1 <= nx && nx <= n && maps[ny - 1][nx - 1] == 1 && dist[ny][nx] == 0){
                    dist[ny][nx] = dist[y][x] + 1;
                    q.addLast(ny);
                    q.addLast(nx);
                }
            }
        }

        return dist[m][n] == 0 ? -1 : dist[m][n];
    }
}
