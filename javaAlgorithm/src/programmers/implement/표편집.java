package programmers.implement;

import java.util.ArrayDeque;
import java.util.Deque;

public class 표편집 {
    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++)
            nodes[i] = new Node();

        for(int i=1;i<n;i++){
            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }

        Node now = nodes[k];
        Deque<Node> q = new ArrayDeque<>();

        for(String command : cmd){
            char c = command.charAt(0);
            if(c == 'U'){
                int idx = Integer.parseInt(command.substring(2));
                while (idx-- > 0)
                    now = now.prev;

            }else if(c == 'D'){
                int idx = Integer.parseInt(command.substring(2));
                while(idx-- > 0)
                    now = now.next;
            }else if(c == 'C'){
                q.addLast(now);
                now.remove = true;
                Node prev = now.prev;
                Node next = now.next;

                if(prev != null){
                    prev.next = next;
                }
                if(next != null){
                    next.prev = prev;
                    now = next;
                }else{
                    now = prev;
                }
            }else{
                Node restore = q.removeLast();
                restore.remove = false;
                Node prev = restore.prev;
                Node next = restore.next;

                if(prev != null){
                    prev.next = restore;
                }
                if(next != null){
                    next.prev = restore;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(nodes[i].remove)
                sb.append("X");
            else
                sb.append("O");
        }

        return sb.toString();
    }

    class Node{
        Node prev;
        Node next;
        boolean remove;
    }
}
