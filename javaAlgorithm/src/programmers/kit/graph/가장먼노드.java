package programmers.kit.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        boolean[] visit = new boolean[n + 1];
        List<Integer>[] list = new ArrayList[n + 1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int[] e : edge){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }

        Deque<Node> q = new ArrayDeque<>();
        q.addLast(new Node(1,0));
        visit[1] = true;
        int[] dept = new int[50001];

        while (!q.isEmpty()){
            Node now = q.removeFirst();
            dept[now.d] += 1;
            for(int next : list[now.n]){
                if(!visit[next]){
                    visit[next] = true;
                    q.addLast(new Node(next, now.d + 1));
                }
            }
        }

        int answer = 0;
        for(int d : dept){
            if(d == 0){
                break;
            }
            answer = d;
        }

        return answer;
    }

    class Node {
        int n;
        int d;

        public Node (int n, int d){
            this.n=n;
            this.d=d;
        }
    }
}
