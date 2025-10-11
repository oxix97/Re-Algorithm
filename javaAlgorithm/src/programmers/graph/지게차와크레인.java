package programmers.graph;

import java.util.*;

public class 지게차와크레인 {
    Map<String,List<int[]>> map;
    boolean[][] visit;
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    int N;
    int M;

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        map = new HashMap<>();
        visit = new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                String k = storage[i].substring(j,j+1);
                int[] arr = {i,j};
                List<int[]> v = map.computeIfAbsent(k,key-> new ArrayList<int[]>());
                v.add(arr);
                map.put(k,v);
            }
        }

        for(String req : requests){
            String r = req.substring(0,1);
            if(!map.containsKey(r))
                continue;

            if(req.length() == 2){
                for(int[] a : map.get(r)){
                    visit[a[0]][a[1]] = true;
                }
                map.remove(r);
            }else{
                Iterator<int[]> it = map.get(r).iterator();
                List<int[]> rm = new ArrayList<>();
                while(it.hasNext()){
                    int[] a = it.next();
                    int y = a[0];
                    int x = a[1];
                    boolean[][] v = new boolean[N][M];

                    if(dfs(y,x,v)){
                        rm.add(a);
                        it.remove();
                    }
                }

                for(int[] rem : rm){
                    visit[rem[0]][rem[1]] = true;
                }
            }
        }

        int answer = 0;
        for(boolean[] r: visit){
            for(boolean empty : r)
                if(!empty)
                    answer += 1;
        }

        return answer;
    }

    private boolean dfs(int y, int x, boolean[][] v){
        boolean result = false;
        v[y][x] = true;

        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M)
                return true;

            if(!v[ny][nx] && visit[ny][nx]){
                result = result || dfs(ny,nx,v);
            }
        }

        return result;
    }
}
