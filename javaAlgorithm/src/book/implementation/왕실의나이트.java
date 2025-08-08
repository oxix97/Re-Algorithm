package book.implementation;

public class 왕실의나이트 {
    public static void main(String[] args) {
        //input
        String i1 = "a1";
        String i2 = "c2";
        String[] idx = {"a1", "c2"};
        for (String i : idx) {
            solution(i);
        }
    }

    public static void solution(String index) {
        StringBuilder sb = new StringBuilder();
        char[] idx = index.toCharArray();
        int y = idx[0] - 96;
        int x = idx[1] - 48;
        int[][] move = {
                {-2, -1}, {-2, 1},
                {2, -1}, {2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}
        };
        int answer = 0;
        for (int[] m : move) {
            if (outOfRange(y + m[0], x + m[1])) continue;
            ++answer;
        }
        sb.append(answer);
        System.out.println(answer);
    }

    private static boolean outOfRange(int y, int x) {
        return y < 1 || x < 1 || y > 8 || x > 8;
    }
}
