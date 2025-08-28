package programmers.brute_force;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        int N = gems.length;
        int size = Arrays.stream(gems)
                .collect(Collectors.toSet())
                .size();

        Map<String,Integer> map = new HashMap<>();
        int[] answer = new int[] {1, N};
        int left = 0;
        for(int right = 0; right < N; right++){
            map.put(gems[right],map.getOrDefault(gems[right],0) + 1);

            while(map.size() == size){
                if(right - left < answer[1] - answer[0]){
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0){
                    map.remove(gems[left]);
                }

                left += 1;
            }
        }

        return answer;
    }
}
