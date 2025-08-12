package programmers.kit.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class 의상 {
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }

    public static int sol(String[][] clothes) {
        // Step 1: 카테고리별 의상 수를 계산하는 Map 생성
        Map<String, Integer> map = Arrays.stream(clothes)
                .collect(toMap(it -> it[1], it -> 1, Integer::sum));
//        Map<String, Long> map = Arrays.stream(clothes)
//                .collect(groupingBy(it -> it[1], counting()));

        // Step 2: 카테고리별 의상 수 + 1을 곱하여 조합의 수를 계산
        int answer = map.values().stream()
                .map(count -> count + 1)
                .reduce(1, (a, b) -> a * b);

        // Step 3: 아무 의상도 선택하지 않는 경우를 제외하기 위해 -1
        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int answer1 = solution(clothes1);
        int answer2 = solution(clothes2);
        System.out.println(answer1);
        System.out.println(answer2);
    }
}
