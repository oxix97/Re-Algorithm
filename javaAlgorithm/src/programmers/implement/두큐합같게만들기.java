package programmers.implement;

import java.util.ArrayDeque;
import java.util.Deque;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Node a = new Node();
        Node b = new Node();
        for(int i=0;i<queue1.length;i++){
            a.add(queue1[i]);
            b.add(queue2[i]);
        }

        if((a.sum + b.sum) % 2 == 1)
            return -1;

        int cnt = 0;
        while(cnt <= queue1.length * 4){
            if(a.sum == b.sum)
                return cnt;
            if(a.sum < b.sum){
                a.add(b.pop());
            }else{
                b.add(a.pop());
            }
            cnt += 1;
        }

        return -1;
    }

    class Node{
        Deque<Integer> q;
        long sum;

        public Node (){
            this.q = new ArrayDeque<>();
            this.sum = 0;
        }

        public void add(int n){
            q.addLast(n);
            this.sum += n;
        }

        public int pop(){
            int n = q.removeFirst();
            this.sum -= n;
            return n;
        }
    }
}
