package programmers.cumulative;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기 {
    public int solution(int[] topping) {
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();

        for(int t: topping){
            right.put(t,right.computeIfAbsent(t,key->0) + 1);
        }

        int answer = 0;
        for(int i=0;i<topping.length -1;i++){
            int n = topping[i];
            left.put(n,left.computeIfAbsent(n,key->0) + 1);
            if(right.get(n) == 1){
                right.remove(n);
            }else{
                right.put(n,right.get(n) - 1);
            }

            if(left.size() == right.size())
                answer += 1;
        }

        return answer;
    }
}
