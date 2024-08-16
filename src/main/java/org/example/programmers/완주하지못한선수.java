package org.example.programmers;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[][] participants = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };
        String[][] completions = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };
        for (int i = 0; i < participants.length; i++) {
            String answer = solution(participants[i], completions[i]);
            System.out.println(answer);
        }
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = Arrays.stream(participant)
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));

        for (String comp : completion) {
            if (map.get(comp) == 1) map.remove(comp);
            else map.put(comp, map.get(comp) - 1);
        }
        return map.keySet().iterator().next();
    }
}
