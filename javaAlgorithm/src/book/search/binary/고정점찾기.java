package book.search.binary;

public class 고정점찾기 {
    public static void main(String[] args) {
        //input
        int a1 = solution(5, new int[]{-15, -6, 1, 3, 7});
        int a2 = solution(7, new int[]{-15, -4, 2, 8, 9, 13, 15});
        int a3 = solution(7, new int[]{-15, -4, 3, 8, 9, 13, 15});

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
    }

    private static int solution(int n, int[] arr) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
