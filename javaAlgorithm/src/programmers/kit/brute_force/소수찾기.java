package programmers.kit.brute_force;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    Set<Integer> set;
    boolean[] visit;
    String[] nums;

    public int solution(String numbers) {
        set = new HashSet<>();
        nums = numbers.split("");
        visit = new boolean[nums.length];

        recursion("");
        int answer = 0;
        for(int n : set){
            if(primary(n)){
                answer += 1;
            }
        }

        return answer;
    }

    private boolean primary(int n){
        if(n == 1 || n == 0){
            return false;
        }
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    private void recursion(String now){
        for(int i=0;i<nums.length;i++){
            if(!visit[i]){
                visit[i] = true;
                String next = now + nums[i];
                set.add(Integer.parseInt(next));
                recursion(next);
                visit[i] = false;
            }
        }
    }
}
