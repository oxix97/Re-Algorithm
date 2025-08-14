package programmers.kit.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호 {
    boolean solution(String s) {
        char[] str = s.toCharArray();
        Deque<Integer> q = new ArrayDeque<>();

        for(char c : str){
            if(c == '('){
                q.addLast(1);
            }else{
                if(q.isEmpty()){
                    return false;
                }
                q.removeLast();
            }
        }

        return q.isEmpty();
    }
}
