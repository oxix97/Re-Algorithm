package programmers.implement;

import java.util.ArrayList;
import java.util.List;

public class 줄서는방법 {
    public int[] solution(int n, long k) {
        List<Integer> num = new ArrayList<>();
        long[] f = new long[n + 1];
        f[0] = 1;
        for(int i=1;i<=n;i++){
            f[i] = f[i - 1] * i;
            num.add(i);
        }

        k -= 1;
        int piv = 0;
        int[] answer = new int[n];
        for(int i = n;i > 0;i--){
            int idx = (int) (k / f[i - 1]);
            answer[piv++] = num.get(idx);
            num.remove(idx);
            k %= f[i - 1];
        }

        return answer;
    }
}
