package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> primeNumbers;
    static final int MAX_VALUE = 4_000_000;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        primeNumbers = getPrimeNumbers();

        int left = 0;
        int right = 0;
        int len = primeNumbers.size();
        int sum = 0;

        while (true) {
            if (sum >= N)
                sum -= primeNumbers.get(left++);
            else if (right == len)
                break;
            else
                sum += primeNumbers.get(right++);

            if (sum == N)
                answer += 1;
        }

        System.out.println(answer);
    }

    private static List<Integer> getPrimeNumbers() {
        boolean[] prime = new boolean[MAX_VALUE + 1];
        prime[0] = prime[1] = true;

        List<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= MAX_VALUE; i++) {
            if (prime[i]) continue;

            for (int j = i * i; j <= MAX_VALUE; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 2; i <= MAX_VALUE; i++) {
            if (!prime[i])
                list.add(i);
        }

        return list;
    }
}
