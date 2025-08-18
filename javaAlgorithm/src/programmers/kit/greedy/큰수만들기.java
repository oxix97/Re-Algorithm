package programmers.kit.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class 큰수만들기 {

    public String solution(String number, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        for(String num : number.split("")){
            int n = Integer.parseInt(num);

            while(!q.isEmpty() && k > 0 && q.peekLast() < n){
                q.removeLast();
                k -= 1;
            }

            q.addLast(n);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            sb.append(q.removeFirst());
        }
        return sb.substring(0,sb.length() - k);
    }
}
