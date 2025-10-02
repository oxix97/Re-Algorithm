package programmers.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 리코쳇로봇 {
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    int N;
    int M;
    public int solution(String[] board) {
        this.N = board.length;
        this.M = board[0].length();
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        int[][] dist = new int[N][M];
        for(int[] d : dist)
            Arrays.fill(d,Integer.MAX_VALUE);

        for(int i=0;i<N;i++){
            boolean find = false;
            for(int j=0;j<M;j++){
                if(board[i].charAt(j) == 'R'){
                    find = true;
                    visit[i][j] = true;
                    q.add(new int[] {i,j});
                    dist[i][j] = 0;
                    break;
                }
            }
            if(find)
                break;
        }

        while(!q.isEmpty()){
            int[] n = q.removeFirst();
            int y = n[0];
            int x = n[1];

            if(board[y].charAt(x) == 'G'){
                return dist[y][x];
            }

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                while(check(ny,nx) && board[ny].charAt(nx) != 'D'){
                    ny += dy[i];
                    nx += dx[i];
                }
                ny -= dy[i];
                nx -= dx[i];
                if(dist[y][x] + 1 < dist[ny][nx]){
                    dist[ny][nx] = dist[y][x] + 1;
                    q.addLast(new int[] {ny,nx});
                }
            }
        }

        return -1;
    }

    private boolean check(int y, int x){
        return 0<= y && y < N && 0 <= x && x < M;
    }
}
