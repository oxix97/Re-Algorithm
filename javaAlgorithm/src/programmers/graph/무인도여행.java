package programmers.graph;

import java.util.ArrayList;
import java.util.List;

public class 무인도여행 {
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    String[] maps;
    boolean[][] visit;
    int N;
    int M;
    public int[] solution(String[] maps) {
        this.maps = maps;
        this.N = maps.length;
        this.M = maps[0].length();
        this.visit = new boolean[N][M];
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visit[i][j] && maps[i].charAt(j) != 'X'){
                    int v = dfs(i,j);
                    answer.add(v);
                }
            }
        }

        if(answer.isEmpty())
            return new int[] {-1};

        return answer.stream()
                .mapToInt(it->it)
                .sorted()
                .toArray();
    }

    private int dfs(int y, int x){
        visit[y][x] = true;
        int v = Integer.parseInt(maps[y].substring(x,x+1));
        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0 <= ny && ny < N && 0 <= nx && nx < M && !visit[ny][nx] && maps[ny].charAt(nx) != 'X'){
                v += dfs(ny,nx);
            }
        }

        return v;
    }
}
