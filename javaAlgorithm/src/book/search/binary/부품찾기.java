package book.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 부품찾기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] nArr, mArr;

    public static void main(String[] args) throws IOException {
        //input
        inputs();
//        solution1();
        solution2();
        output();
    }

    private static void solution1() {
        List<Integer> list = Arrays.stream(nArr).boxed().toList();
        Arrays.stream(mArr)
                .map(it -> Collections.binarySearch(list, it))
                .forEach(it -> {
                    if (it == -1) sb.append("no").append(' ');
                    else sb.append("yes").append(' ');
                });
    }

    private static void solution2() {
        Arrays.sort(mArr);
        for (int target : mArr) {
            int start = 0;
            int end = N - 1;
            boolean find = false;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nArr[mid] == target) {
                    find = true;
                    break;
                }
                if (nArr[mid] > target) { // 중간 값이 target 보다 큰 경우 -> end 지점 감소
                    end = mid - 1;
                } else { // 중간 값이 target 보다 작은 경우 -> start 지점 증가
                    start = mid + 1;
                }
            }
            sb.append(find ? "yes" : "no").append(' ');
        }
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        nArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        mArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void output() {
        System.out.println(sb);
    }
}
