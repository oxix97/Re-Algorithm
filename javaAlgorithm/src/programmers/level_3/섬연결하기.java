package programmers.level_3;

import java.util.*;

class 섬연결하기 {
    public int solution(int n, int[][] costs) {
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = i;
        
        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        for(int[] cost : costs){
            q.add(new Node(cost[0],cost[1],cost[2]));
        }
        
        int answer = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            
            int a = find(dist, node.a);
            int b = find(dist,node.b);
            
            if(a != b){
                dist[b] = a;
                answer += node.cost;
            }
        }
        
        return answer;
    }
    
    private int find(int[] a, int b){
        if(a[b] == b) return b;
        return find(a,a[b]);
    }
    
    static class Node {
        int a;
        int b;
        int cost;
        
        public Node(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
