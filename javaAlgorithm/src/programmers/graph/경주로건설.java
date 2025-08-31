package programmers.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
    int N;
    int[] dy = {1,0,-1,0};
    int[] dx = {0,-1,0,1};

    public int solution(int[][] board) {
        this.N = board.length;
        Queue<int[]> q = new LinkedList<>();
        int[][][] dist = new int[N][N][4];

        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                Arrays.fill(dist[i][j],Integer.MAX_VALUE);

        for(int i=0;i<4;i++){
            dist[0][0][i] = 0;
        }

        if(board[0][1] == 0){
            dist[0][1][3] = 100;
            q.add(new int[]{0,1,3});
        }
        if(board[1][0] == 0){
            dist[1][0][0] = 100;
            q.add(new int[]{1,0,0});
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int d = now[2];

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(check(ny,nx) && board[ny][nx] == 0){
                    int cost;
                    if(d == i){
                        cost = dist[y][x][d] + 100;
                    }else{
                        cost = dist[y][x][d] + 600;
                    }

                    if(cost < dist[ny][nx][i]){
                        dist[ny][nx][i] = cost;
                        q.add(new int[]{ny,nx,i});
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            answer = Math.min(answer,dist[N - 1][N - 1][i]);
        }
        return answer;
    }

    private boolean check(int y, int x){
        return 0 <= y && y < N && 0 <= x && x < N;
    }
}
