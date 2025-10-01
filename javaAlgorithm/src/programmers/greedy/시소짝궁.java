package programmers.greedy;

import java.util.HashMap;
import java.util.Map;

public class 시소짝궁 {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        long answer = 0;
        for(int w : weights){
            double dw = (double) w;

            if(map.containsKey(dw)){
                answer += map.get(dw);
            }
            if(map.containsKey(dw * 2 / 3)){
                answer += map.get(dw * 2 / 3);
            }
            if(map.containsKey(dw / 2)){
                answer += map.get(dw / 2);
            }
            if(map.containsKey(dw * 3 / 4)){
                answer += map.get(dw*3 /4);
            }
            map.put(dw,map.computeIfAbsent(dw,key->0) + 1);
        }

        return answer;
    }
}
