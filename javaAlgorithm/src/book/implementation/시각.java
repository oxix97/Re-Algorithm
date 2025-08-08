package book.implementation;

public class 시각 {
    public static void main(String[] args) {
        //input
        int N = 5;
        solution(N);
    }

    public static void solution(int n) {
        StringBuilder sb = new StringBuilder();

        int h = 0, m = 0, s = 0;
        int count = 0;
        while (h != n + 1) {
            if (isContain(h + "" + m + s)) ++count;
            if (++s == 60) {
                s = 0;
                ++m;
            }
            if (m == 60) {
                m = 0;
                ++h;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }

    private static boolean isContain(String s) {
        return s.contains("3");
    }
}