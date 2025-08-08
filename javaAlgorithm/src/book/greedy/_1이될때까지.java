package book.greedy;

public class _1이될때까지 {
    public static void main(String[] args) {
        //input
        int n = 25;
        int k = 5;

        solution(n, k);
        solution(17,4);
    }

    public static void solution(int n, int k) {
        int count = 0;
        while (n != 1) {
            if (n % k == 0) n /= k;
            else n--;
            count++;
        }
        System.out.println(count);
    }
}
