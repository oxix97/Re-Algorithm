package programmers.greedy;

import java.util.*;

public class 인사고과 {
    public int solution(int[][] scores) {
        int N = scores.length;

        List<Score> sc = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sc.add(new Score(i, scores[i][0], scores[i][1]));
        }

        Collections.sort(sc, (o1, o2) -> {
            if (o1.a == o2.a) return o1.b - o2.b;
            return o2.a - o1.a;
        });

        int maxB = -1;
        int sum = 0;
        int rank = 1;

        for (Score s : sc) {
            if (s.idx == 0) {
                sum = s.total;
            }

            if (s.b < maxB) {
                if (s.idx == 0)
                    return -1;
                continue;
            } else {
                maxB = s.b;
            }

            if (s.total > sum) {
                rank++;
            }
        }

        return rank;
    }

    class Score {
        int idx, a, b, total;

        public Score(int idx, int a, int b) {
            this.idx = idx;
            this.a = a;
            this.b = b;
            this.total = a + b;
        }
    }
}
