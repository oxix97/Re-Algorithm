package programmers.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 튜플 {
    public int[] solution(String s) {
        List<Node> result = new ArrayList<>();
        String[] str = s.substring(2,s.length()-2)
                .split("\\},\\{");
        for(String ss : str){
            result.add(new Node(ss));
        }
        Collections.sort(result);

        List<Integer> answer = new ArrayList<>();
        for(Node node : result){
            for(int n : node.num){
                if(!answer.contains(n)){
                    answer.add(n);
                    break;
                }
            }
        }

        return answer.stream()
                .mapToInt(it->it)
                .toArray();
    }

    class Node implements Comparable<Node>{
        int[] num;
        public Node(String s){
            this.num = Arrays.stream(s.split(","))
                    .map(it->Integer.parseInt(it))
                    .mapToInt(it->it)
                    .toArray();
        }

        @Override
        public int compareTo(Node o){
            return this.num.length - o.num.length;
        }
    }
}
