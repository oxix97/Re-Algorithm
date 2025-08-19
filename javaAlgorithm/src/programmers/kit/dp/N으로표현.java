package programmers.kit.dp;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {
    public int solution(int N, int number) {
        Set<Integer>[] set = new HashSet[10];
        for(int i=1;i<10;i++){
            int n = Integer.parseInt(String.valueOf(N).repeat(i));
            set[i] = new HashSet<>();
            set[i].add(n);
        }

        for(int i=1;i<=9;i++){
            for(int j=1;j < i;j++){
                for(int a : set[j]){
                    for(int b : set[i - j]){
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        if(b != 0){
                            set[i].add((int) a / b);
                        }
                    }
                }
            }

            if(set[i].contains(number)){
                return i;
            }
        }

        return -1;
    }
}
