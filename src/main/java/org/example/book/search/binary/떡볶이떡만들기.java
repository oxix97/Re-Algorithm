package org.example.book.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        Arrays.sort(arr);

        //1. 이진 탐색을 통해 mid 값을 구한다.
        int start = 0;
        int end = N - 1;
        int answer = 0;
        while (start <= end) {
            //2. mid값을 기준으로 떡을 썰어서 M이 나오는지 확인 -> sum
            int mid = (start + end) / 2;
            int sum = Arrays.stream(arr)
                    .filter(it -> it > arr[mid])
                    .map(it -> it - arr[mid])
                    .sum();
            //3. 중간 값이 M보다 큰 경우 end = mid - 1;
            if (sum > M) end = mid - 1;
            else { //4. 중간 값이 M보다 작거나 같은 경우 start = mid + 1;
                if (sum == M) answer = Math.max(answer, arr[mid]);
                start = mid + 1;
            }
        }
        sb.append(answer);
    }

    private static void inputs() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    private static void output() {
        System.out.println(sb);
    }
}
