package programmers.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class _110옮기기 {
    public String[] solution(String[] s) {
        for(int i=0;i<s.length;i++){
            s[i] = solv(s[i]);
        }

        return s;
    }

    private String solv(String str){
        Deque<Character> q = new ArrayDeque<>();
        int cnt = 0;
        for(Character c : str.toCharArray()){
            if(c == '0' && q.size() >= 2){
                char b = q.removeLast();
                char a = q.removeLast();
                if(a == '1' && b == '1'){
                    cnt += 1;
                }else{
                    q.addLast(a);
                    q.addLast(b);
                    q.addLast(c);
                }
            }else{
                q.addLast(c);
            }
        }

        if(cnt == 0)
            return str;

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty())
            sb.append(q.removeFirst());

        int idx = sb.length() - 1;
        while(idx >= 0 && sb.charAt(idx) == '1')
            idx -= 1;

        String x = "110".repeat(cnt);
        sb.insert(idx + 1,x);

        return sb.toString();
    }
}
