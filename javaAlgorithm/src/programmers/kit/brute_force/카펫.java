package programmers.kit.brute_force;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for(int h = 1;h<=(int)Math.sqrt(total);h++){
            if(total % h != 0) continue;

            int w = total / h;
            if((w - 2) * (h - 2) == yellow){
                return new int[] {w,h};
            }

        }
        return new int[] {-1,-1};
    }
}
