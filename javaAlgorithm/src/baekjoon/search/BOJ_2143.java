package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2143 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M;
    static int[] A, B;
    static long answer = 0;

//1. 입력 값 받기
//2. A,B 정수 배열에 대한 부분 수열의 합을 구한 리스트 생성
//3. 비교 대상 오름차순 정렬
//4. 이분탐색을 통해 T 값이 되는 경우를 구하기

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        List<Long> sumA = getSumList(A);
        List<Long> sumB = getSumList(B);

        Collections.sort(sumB);

        for (long a : sumA) {
            long target = T - a;

            int low = getLowBound(target, sumB);
            int high = getUpperBound(target, sumB);

            answer += high - low;
        }

        System.out.println(answer);
    }

    private static int getLowBound(long target, List<Long> list) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (target <= list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int getUpperBound(long target, List<Long> list) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (target < list.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static List<Long> getSumList(int[] arr) {
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }

        return list;
    }
}
