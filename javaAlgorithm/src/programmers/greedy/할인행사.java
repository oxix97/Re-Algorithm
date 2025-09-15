package programmers.greedy;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        int answer = 0;
        for(int d=0;d<=discount.length - 10;d++){
            Map<String,Integer> tmp = new HashMap<>(map);
            for(int i=d;i<d + 10;i++){
                String key = discount[i];
                if(tmp.containsKey(key)){
                    int value = tmp.get(key) - 1;
                    if(value == 0){
                        tmp.remove(key);
                    }else{
                        tmp.put(key,value);
                    }
                }
            }
            if(tmp.isEmpty()){
                answer += 1;
            }
        }

        return answer;
    }
}
