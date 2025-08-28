package programmers.greedy;

import java.util.Arrays;

public class 징검다리건너기 {
    int[] stones;
    int k;
    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;
        int left = 1;
        int right = Arrays.stream(stones).max().getAsInt();
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(int v){
        int cnt = 0;
        for(int stone : stones){
            if(stone - v < 0){
                cnt += 1;
            }else{
                cnt = 0;
            }

            if(cnt >= k){
                return false;
            }
        }

        return true;
    }
}
