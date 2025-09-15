package programmers.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int t : tangerine){
            int cnt = map.computeIfAbsent(t, (it -> 0)) + 1;
            map.put(t,cnt);
        }
        List<Integer> list = map.values().stream()
                .sorted((o1,o2)->o2-o1)
                .collect(Collectors.toList());

        int answer = 0;
        for(int n : list){
            if(k <= 0)
                break;
            answer += 1;
            k -= n;
        }
        return answer;
    }
}
