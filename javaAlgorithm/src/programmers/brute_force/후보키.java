package programmers.brute_force;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1.조합 1 ~ n개의 조합 경우의 수 구하기
// 2.유일성을 만족하는지 검사
// 3.최소성을 만족하는지 검사
// 4.모든 조건 만족 시 answer++
public class 후보키 {
    int r;
    int c;
    String[][] relation;
    List<Set<Integer>> keys = new ArrayList<>();

    public int solution(String[][] relation) {
        this.relation = relation;
        this.r = relation.length;
        this.c = relation[0].length;

        for (int i = 1; i <= c; i++) {
            combination(0, 0, i, new HashSet<>());
        }

        return keys.size();
    }

    private boolean unique(Set<Integer> current) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int idx : current) {
                sb.append(relation[i][idx]).append(",");
            }
            if (!set.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean minimal(Set<Integer> current) {
        for (Set<Integer> s : keys) {
            if (current.containsAll(s))
                return false;
        }
        return true;
    }

    private void combination(int start, int depth, int size, Set<Integer> current) {
        if (depth == size) {
            if (!unique(current))
                return;
            if (!minimal(current))
                return;
            keys.add(new HashSet<>(current));
            return;
        }

        for (int i = start; i < c; i++) {
            current.add(i);
            combination(i + 1, depth + 1, size, current);
            current.remove(i);
        }
    }
}

