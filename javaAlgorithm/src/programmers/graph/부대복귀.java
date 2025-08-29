package programmers.graph;

import java.util.*;

public class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] road = new ArrayList[n + 1];

        for(int i=0;i<=n;i++)
            road[i] = new ArrayList<>();

        for(int[] r : roads){
            int a = r[0];
            int b = r[1];
            road[a].add(b);
            road[b].add(a);
        }

        int[] result = bfs(n,road,sources,destination);
        int[] answer = new int[sources.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = result[sources[i]];
        }
        return answer;
    }

    private int[] bfs(int n, List<Integer>[] road, int[] sources, int destination){
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(destination);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;

        while(!q.isEmpty()){
            int now = q.removeFirst();
            for(int next : road[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.addLast(next);
                }
            }
        }

        return dist;
    }
}
