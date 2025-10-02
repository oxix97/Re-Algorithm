package programmers.implement;

import java.util.*;

public class 메뉴리뉴얼 {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int n : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                char[] c = order.toCharArray();
                Arrays.sort(c);
                order = new String(c);
                List<String> comb = generate(order, n);
                for (String s : comb)
                    map.put(s, map.computeIfAbsent(s, k -> 0) + 1);
            }

            if (!map.isEmpty()) {
                int max = Collections.max(map.values());

                if (max >= 2) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        if (entry.getValue() == max) {
                            answer.add(entry.getKey());
                        }
                    }
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private List<String> generate(String order, int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        combination(order, n, 0, sb, result);
        return result;
    }

    private void combination(String order, int n, int start, StringBuilder sb, List<String> result) {
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combination(order, n, i + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
