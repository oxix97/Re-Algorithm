package programmers.kit.hash;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 폰켓몬 {
    public static int solution(int[] nums) {
        return Math.min(Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet())
                .size(), nums.length / 2);
    }

    public static void main(String[] args) {
        int answer = solution(new int[]{3,3,3,2,2,2});
        System.out.println(answer);
    }
}
