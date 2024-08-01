package org.example.programmers;

import java.util.Arrays;

public class 실패율 {
    public static void main(String[] args) {
        int[] s1 = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] s2 = solution(4, new int[]{4, 4, 4, 4, 4});
        int[] s3 = solution(5, new int[]{5, 5, 5, 5, 5, 5, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5});
        int[] s4 = solution(5, new int[]{4, 11, 6, 7, 8, 3, 4, 5, 1, 2, 9, 7, 7, 4, 4, 3, 2, 2, 2, 1, 5, 2, 6, 8, 2, 10, 9, 10});
        int[] s5 = solution(10, new int[]{1, 1, 1, 1, 1, 1, 2});
        print(s1);
        print(s2);
        print(s3);
        print(s4);
        print(s5);
    }

    private static void print(int[] s1) {
        for (int i : s1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*  실패율은 다음과 같이 정의한다.
        스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
     */
    public static int[] solution(int N, int[] stages) {
        Stage[] result = new Stage[N];
        for (int i = 0; i < N; i++) result[i] = new Stage(i + 1, 0);
        int user = stages.length;

        for (int i = 0; i < N; i++) {
            //해당 스테이지 인원 몇명있는지 확인
            int stage = i + 1;

            int count = (int) Arrays.stream(stages).filter(it -> it == stage).count();

            // 실패율
            result[i].avg = (user == 0 ? 0 : (double) count / user);

            //전체 인원에서 스테이지 도전 중인 인원 제외
            user -= count;
        }
        return Arrays.stream(result)
                .sorted((o1, o2) -> {
                    if (o2.avg == o1.avg) return o1.idx - o2.idx;
                    return Double.compare(o2.avg, o1.avg);
                })
                .mapToInt(it -> it.idx)
                .toArray();
    }

    static class Stage {
        int idx;
        double avg;

        public Stage(int idx, double avg) {
            this.idx = idx;
            this.avg = avg;
        }
    }
}
