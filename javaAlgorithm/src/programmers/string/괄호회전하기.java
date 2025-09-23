package programmers.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호회전하기 {
    public int solution(String s) {
        int len = s.length();
        String str = s.repeat(2);
        int answer = 0;
        for(int left=0;left<len;left++){
            if(check(str.substring(left,left + len))){
                answer += 1;
            }
        }
        return answer;
    }

    private boolean check(String s){
        Deque<Character> q = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == ')' || c == ']' || c == '}'){
                if(q.isEmpty())
                    return false;
                if(c == ')' && q.removeLast() != '(')
                    return false;
                if(c == '}' && q.removeLast() != '{')
                    return false;
                if(c == ']' && q.removeLast() != '[')
                    return false;
            }else{
                q.addLast(c);
            }
        }

        return q.isEmpty();
    }
}
