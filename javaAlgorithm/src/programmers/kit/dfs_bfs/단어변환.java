package programmers.kit.dfs_bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 단어변환 {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }

        Deque<Node> q = new ArrayDeque<>();
        q.addLast(new Node(begin, 0));

        while(!q.isEmpty()){
            Node now = q.removeFirst();

            if(now.w.equals(target)){
                return now.cnt;
            }

            for(String word : words){
                int cnt = 0;
                for(int i=0;i<word.length();i++){
                    if(word.charAt(i) == now.w.charAt(i)){
                        cnt += 1;
                    }
                }
                if(cnt == word.length() - 1){
                    q.addLast(new Node(word,now.cnt + 1));
                }
            }

        }

        return 0;
    }

    class Node{
        String w;
        int cnt;

        public Node (String w, int cnt){
            this.w = w;
            this.cnt = cnt;
        }
    }
}
