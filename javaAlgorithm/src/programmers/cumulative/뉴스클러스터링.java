package programmers.cumulative;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        final int N = 65536;
        Map<String,Integer> s1 = transfer(str1);
        Map<String,Integer> s2 = transfer(str2);

        Set<String> set = new HashSet<>(s1.keySet());
        set.addAll(s2.keySet());

        if(set.isEmpty()){
            return N;
        }

        int A = 0;
        int B = 0;
        for(String key : set){
            int a = s1.computeIfAbsent(key,k->0);
            int b = s2.computeIfAbsent(key,k->0);

            A += Math.min(a,b);
            B += Math.max(a,b);
        }

        return (int) ((double) A / B * N);
    }

    private Map<String,Integer> transfer(String str){
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<str.length() - 1;i++){
            String s = str.substring(i,i + 2).toUpperCase();
            if('A' <= s.charAt(0) && s.charAt(0) <= 'Z' && 'A' <= s.charAt(1) && s.charAt(1) <= 'Z'){
                map.put(s,map.computeIfAbsent(s,key->0) + 1);
            }
        }
        return map;
    }
}
