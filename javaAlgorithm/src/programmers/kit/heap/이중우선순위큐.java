package programmers.kit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<Integer>((o1,o2)-> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();

        for(String operation : operations){
            String[] s = operation.split(" ");
            String op = s[0];
            int n = Integer.parseInt(s[1]);
            if(op.equals("I")){
                max.add(n);
                min.add(n);
            }else if(n == 1 && !max.isEmpty()){
                min.remove(max.poll());
            }else if(n == -1 && !min.isEmpty()){
                max.remove(min.poll());
            }
        }

        if(max.isEmpty() || min.isEmpty()){
            return new int[] {0,0};
        }

        return new int[] {max.poll(),min.poll()};
    }
}
