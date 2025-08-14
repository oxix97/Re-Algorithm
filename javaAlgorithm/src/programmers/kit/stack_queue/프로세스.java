package programmers.kit.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class 프로세스 {
    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> o2 - o1);
        Deque<Node> q = new ArrayDeque<>();

        for(int i=0;i<priorities.length;i++){
            pq.add(priorities[i]);
            q.addLast(new Node(i, priorities[i]));
        }

        int answer = 1;
        while (!pq.isEmpty()){
            int priority = pq.poll();

            while (true){
                Node node = q.removeFirst();
                if(node.priority == priority){
                    if(location == node.idx){
                        return answer;
                    }
                    break;
                }
                q.addLast(node);
            }

            answer += 1;
        }

        return answer;
    }

    static class Node {
        int idx;
        int priority;

        public Node(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
}
