package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < speeds.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] == 0)
                q.add(day);
            else q.add(day + 1);

        }

        List<Integer> list = new ArrayList<>();
        int count = 1;
        int v = q.poll();

        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (v >= tmp) {
                count++;
            } else {
                list.add(count);
                count = 1;
                v = tmp;
            }
        }
        list.add(count);
        return list.stream().mapToInt(it -> it).toArray();
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        print(answer);
    }

    private static void print(int[] answer) {
        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}
