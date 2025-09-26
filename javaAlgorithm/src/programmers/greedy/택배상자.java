package programmers.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class 택배상자 {
    public int solution(int[] order) {
        Deque<Integer> q = new ArrayDeque<>();
        int idx = 0;

        for(int i=1;i<=order.length;i++){
            if(order[idx] == i){
                idx += 1;
            }else{
                q.addLast(i);
            }

            while(idx < order.length && !q.isEmpty() && order[idx] == q.peekLast()){
                q.removeLast();
                idx += 1;
            }
        }

        return idx;
    }
}
