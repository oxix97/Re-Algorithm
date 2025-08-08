package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @1.국어 점수가 감소하는 순서로
 * @2.국어 점수가 같으면 영어 점수가 증가하는 순서로
 * @3.국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * @4.모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 */
public class BOJ_10825 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static PriorityQueue<Student> q;

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            q.add(new Student(name, korean, english, math));
        }
    }

    private static void solution() {
        while (!q.isEmpty()) {
            String name = q.poll().name;
            sb.append(name).append('\n');
        }
    }

    private static void output() {
        System.out.println(sb);
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int math;
        int english;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.math = math;
            this.english = english;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean == o.korean) {
                if (this.english == o.english) {
                    return o.math - this.math;
                }
                return this.english - o.english;
            }
            return o.korean - this.korean;
        }
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }
}
