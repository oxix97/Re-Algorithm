package org.example.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18428 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static String[][] arr;

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken();
            }
        }
    }

    private static void solution(int cnt) {
        // 선생님은 장애물에 막힌 것을 제외한 상,하,좌,우 모두 볼 수 있다.
        //3개의 장애물을 설치하여 모든 학생들을 감시로부터 피하도록 하는게 목적

        //2. 선생님들의 위치에서 시야 확인
        if (cnt == 0) {
            findStudent();
            return;
        }

        //1. 장애물 설치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j].equals("X")) {
                    arr[i][j] = "O";
                    solution(cnt - 1);
                    arr[i][j] = "X";
                }
            }
        }
    }

    private static void findStudent() {
        Queue<Integer> q = new LinkedList<>();
        String[][] field = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                field[i][j] = arr[i][j];
                if (field[i][j].equals("T")) {
                    q.add(i);
                    q.add(j);
                }
            }
        }

        //3. 2번의 결과가 YES가 나올 때 까지 반복 -> 바로 YES 출력
        while (!q.isEmpty()) {
            int y = q.poll();
            int x = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y;
                int nx = x;
                while (true) {
                    if (rangeException(ny += dy[i], nx += dx[i]) || field[ny][nx].equals("O")) break;
                    if (field[ny][nx].equals("S")) return;
                }
            }
        }

        System.out.println("YES");
        System.exit(0);
    }

    private static boolean rangeException(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }

    public static void main(String[] args) throws IOException {
        inputs();
        solution(3);
        System.out.println("NO");
    }
}
