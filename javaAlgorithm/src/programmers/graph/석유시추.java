package programmers.graph;

import java.util.*;

public class 석유시추 {
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    int n,m;
    boolean[][] visit;
    int[][] arr;
    int[][] land;
    public int solution(int[][] land) {
        this.n = land.length;
        this.m = land[0].length;
        this.land = land;
        arr = new int[n][m];
        visit = new boolean[n][m];

        List<Integer> result = new ArrayList<>();
        result.add(0);

        int idx = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && land[i][j] == 1){
                    int v = bfs(i,j,idx++);
                    result.add(v);
                }
            }
        }

        int answer = 0;
        for(int j=0;j<m;j++){
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<n;i++){
                set.add(arr[i][j]);
            }

            int sum = 0;
            for(int num : set)
                sum += result.get(num);

            answer = Math.max(answer,sum);
        }
        return answer;
    }

    private int bfs(int y, int x, int idx){
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{y,x});
        arr[y][x] = idx;
        visit[y][x] = true;
        int v = 1;
        while(!q.isEmpty()){
            int[] n = q.removeFirst();

            for(int i=0;i<4;i++){
                int ny = dy[i] + n[0];
                int nx = dx[i] + n[1];

                if(hasNext(ny,nx)){
                    q.addLast(new int[]{ny,nx});
                    arr[ny][nx] = idx;
                    v += 1;
                    visit[ny][nx] = true;
                }
            }
        }

        return v;
    }

    private boolean hasNext(int y, int x){
        return 0<= y && y < n && 0<=x && x < m && !visit[y][x] && land[y][x] == 1;
    }
}
