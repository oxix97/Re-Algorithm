package programmers.kit.brute_force;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for(int[] size : sizes){
            int a = Math.max(size[0],size[1]);
            int b = Math.min(size[0],size[1]);

            w = Math.max(w,a);
            h = Math.max(h,b);
        }

        return w * h;
    }
}
