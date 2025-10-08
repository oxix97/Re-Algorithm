package programmers.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 거리두기확인하기 {
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    public int[] solution(String[][] places) {
        return Arrays.stream(places)
                .map(it->recursion(it))
                .mapToInt(it->it)
                .toArray();
    }

    private int recursion(String[] place){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(place[i].charAt(j) == 'P'){
                    if(bfs(place,i,j))
                        return 0;
                }
            }
        }

        return 1;
    }
    private boolean bfs(String[] place, int y, int x){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[5][5];
        q.add(new int[] {y,x,0});
        visit[y][x] = true;

        while(!q.isEmpty()){
            int[] n = q.removeFirst();
            y = n[0];
            x = n[1];

            if(n[2] >= 2)
                continue;

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(0 <= ny && ny < 5 && 0 <= nx && nx < 5 && place[ny].charAt(nx) != 'X' && !visit[ny][nx]){
                    if(place[ny].charAt(nx) == 'P')
                        return true;
                    visit[ny][nx] = true;
                    q.addLast(new int[]{ny,nx,n[2] + 1});
                }
            }
        }

        return false;
    }
}
