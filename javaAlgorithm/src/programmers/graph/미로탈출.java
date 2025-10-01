package programmers.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class 미로탈출 {
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    public int solution(String[] maps) {
        int N = maps.length;
        int M = maps[0].length();
        boolean[][][] visit = new boolean[N][M][2];
        Deque<Node> q = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i].charAt(j) == 'S'){
                    q.addLast(new Node(i,j,0,0));
                    visit[i][j][0] = true;
                    break;
                }
            }
        }

        int answer = 0;
        while(!q.isEmpty()){
            Node now = q.removeFirst();
            if(maps[now.y].charAt(now.x) == 'L')
                now.lever = 1;
            if(maps[now.y].charAt(now.x) == 'E' && now.lever == 1)
                return now.dist;

            for(int i=0;i<4;i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(0 <= ny && ny < N && 0<= nx && nx < M && maps[ny].charAt(nx) != 'X' && !visit[ny][nx][now.lever]){
                    visit[ny][nx][now.lever] = true;
                    q.addLast(new Node(ny,nx,now.lever,now.dist + 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int y;
        int x;
        int lever;
        int dist;

        public Node(int y,int x,int lever, int dist){
            this.y=y;
            this.x=x;
            this.lever=lever;
            this.dist = dist;
        }
    }
}
