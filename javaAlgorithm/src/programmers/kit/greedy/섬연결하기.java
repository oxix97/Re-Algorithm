package programmers.kit.greedy;

import java.util.PriorityQueue;

public class 섬연결하기 {
    int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int[] cost : costs){
            pq.add(new Node(cost[2],cost[0],cost[1]));
        }

        int answer = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(find(now.a) != find(now.b)){
                union(now.a,now.b);
                answer += now.cost;
            }
        }

        return answer;
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    class Node implements Comparable<Node>{
        int cost;
        int a;
        int b;

        public Node(int cost, int a, int b){
            this.cost = cost;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
}
