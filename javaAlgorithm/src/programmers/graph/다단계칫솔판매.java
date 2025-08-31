package programmers.graph;

import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,Node> map = new HashMap<>();
        for(int i=0;i<enroll.length;i++){
            String ref = referral[i];
            String name = enroll[i];
            map.put(name,new Node(ref,0));
        }

        for(int i=0;i<seller.length;i++){
            String name = seller[i];
            int cost = amount[i] * 100;

            while(map.containsKey(name) && cost > 0){
                int v = (int) Math.ceil(cost * 0.9);
                Node node = map.get(name);
                node.amount += v;
                name = node.ref;
                cost -= v;
            }
        }

        int[] answer = new int[enroll.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = map.get(enroll[i]).amount;
        }
        return answer;
    }

    class Node{
        public String ref;
        public int amount;

        public Node (String ref, int amount){
            this.ref = ref;
            this.amount = amount;
        }
    }
}
