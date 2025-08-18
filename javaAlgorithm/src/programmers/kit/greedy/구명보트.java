package programmers.kit.greedy;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left += 1;
            }
            right -= 1;
            answer += 1;
        }
        return answer;
    }
}
