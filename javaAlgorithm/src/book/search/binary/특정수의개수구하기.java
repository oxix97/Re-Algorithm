package book.search.binary;

import java.io.IOException;

public class 특정수의개수구하기 {
    private static int solution(int n, int target, int[] arr) {
        int left = 0;
        int right = n - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                if (arr[mid] == target) {
                    int L = mid;
                    int R = mid;
                    while (arr[L++] == target) answer++;
                    while (arr[--R] == target) answer++;
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer == 0 ? -1 : answer;
    }

    public static void main(String[] args) throws IOException {
        int a1 = solution(7, 2, new int[]{1, 1, 2, 2, 2, 2, 3});
        int a2 = solution(7, 4, new int[]{1, 1, 2, 2, 2, 2, 3});

        System.out.println(a1);
        System.out.println(a2);
    }
}
