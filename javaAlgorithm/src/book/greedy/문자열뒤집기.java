package book.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열뒤집기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;

    public static void main(String[] args) throws IOException {
        arr = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        //0으로 만들 때
        int zero = checkNumber(0);

        //1로 만들 때
        int one = checkNumber(1);

        int answer = Math.min(zero, one);
        System.out.println(answer);
    }

    private static int checkNumber(int target) {
        int count = 0;
        boolean check = false;
        for (int n : arr) {
            if (n == target) {
                if (!check) {
                    check = true;
                    ++count;
                }
            } else {
                check = false;
            }
        }
        return count;
    }

}
