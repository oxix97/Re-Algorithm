package programmers.graph;

import java.util.*;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        List<Edge>[] r = new ArrayList[N + 1];
        for(int i=0;i<=N;i++)
            r[i] = new ArrayList<Edge>();
        for(int[] ro : road){
            r[ro[0]].add(new Edge(ro[1],ro[2]));
            r[ro[1]].add(new Edge(ro[0],ro[2]));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        Deque<Edge> q = new ArrayDeque<>();
        q.add(new Edge(1,0));
        while(!q.isEmpty()){
            Edge now = q.removeFirst();
            for(Edge e : r[now.r]){
                if(now.c + e.c < dist[e.r] && now.c + e.c <= K){
                    dist[e.r] = now.c + e.c;
                    q.addLast(new Edge(e.r,now.c + e.c));
                }
            }
        }
        int answer = 0;
        for(int n : dist){
            if(n <= K)
                answer += 1;
        }

        return answer;
    }

    class Edge{
        int r;
        int c;

        public Edge(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
