package programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int n : arr){
            if(q.isEmpty()){
                q.addLast(n);
            }else if(q.peekLast() != n){
                q.addLast(n);
            }
        }

        return q.stream()
                .mapToInt(i->i)
                .toArray();
    }

}
