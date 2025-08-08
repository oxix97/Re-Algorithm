package book.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 만들수없는금액 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static final int MAX_COST = 1_000_000_000; //10억

    public static void main(String[] args) throws IOException {
        inputs();
        solution();
        output();
    }

    private static void solution() {
        //주어진 입력 값 1<= N <= 1,000
        //화폐 단위 1,000,000 이하
        //총합 10억 이하 -> 정수형
        Arrays.sort(arr);
        for (int i = 1; i <= MAX_COST; i++) {
            int cost = i;
            for (int j = N - 1; j >= 0; j--) {
                if (arr[j] > cost) continue;
                cost -= arr[j];
            }
            if (cost != 0) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void inputs() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void output() {
        System.out.println(sb);
    }
}
