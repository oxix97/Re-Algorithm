package programmers.kit.binary;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1L;
        long right = (long) times[times.length - 1] * n;
        long answer = 0L;

        while(left <= right){
            long mid = (left + right) / 2;
            long cnt = 0L;

            for(int time : times){
                cnt += (mid / time);
            }

            if(cnt < n){
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}
