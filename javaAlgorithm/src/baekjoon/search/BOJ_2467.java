package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
    static int a = -1;
    static int b = -1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            binarySearch(i);
        }

        System.out.println(arr[a] + " " + arr[b]);
    }

    private static void binarySearch(int idx) {
        int left = idx + 1;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = arr[idx] + arr[mid];

            if (Math.abs(sum) < Math.abs(answer)) {
                answer = sum;
                a = idx;
                b = mid;
            }

            if (sum == 0) {
                return;
            } else if (sum < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}
