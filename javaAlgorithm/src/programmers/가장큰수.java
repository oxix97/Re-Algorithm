package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장큰수 {
    public static String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());

        return result.charAt(0) == '0' ? "0" : result;
    }

    public static void main(String[] args) {
        int[] n1 = {3, 30, 34, 5, 9};
        int[] n2 = {0, 0, 0, 0};
        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }
}
