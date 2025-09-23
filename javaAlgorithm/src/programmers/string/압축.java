package programmers.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
    public int[] solution(String msg) {
        Map<String,Integer> map = new HashMap<>();
        char ch = 'A';
        int value = 27;
        for(int i=0;i<26;i++){
            map.put(String.valueOf(ch++),i + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<msg.length();){
            String pre = "";
            String now = "";
            for(int j=1;i + j<=msg.length();j++){
                String key = msg.substring(i,i + j);
                if(map.containsKey(key)){
                    pre = key;
                }else{
                    now = key;
                    break;
                }
            }

            if(!now.isEmpty()){
                map.put(now,value++);
            }

            answer.add(map.get(pre));
            i += pre.length();
        }

        return answer.stream()
                .mapToInt(it->it)
                .toArray();
    }
}
