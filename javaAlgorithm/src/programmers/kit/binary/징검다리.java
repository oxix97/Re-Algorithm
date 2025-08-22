package programmers.kit.binary;

import java.util.Arrays;

public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int[] rock = new int[rocks.length + 2];
        rock[0] = 0;
        for(int i=0;i<rocks.length;i++){
            rock[i + 1] = rocks[i];
        }
        rock[rock.length - 1] = distance;
        Arrays.sort(rock);

        int left = 1;
        int right = distance;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            int pos = rock[0];
            for(int i=1;i<rock.length;i++){
                if(rock[i] - pos < mid){
                    cnt += 1;
                }else{
                    pos = rock[i];
                }
            }

            if(cnt <= n){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return answer;
    }
}
