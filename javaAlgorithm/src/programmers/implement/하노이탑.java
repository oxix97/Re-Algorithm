package programmers.implement;

import java.util.ArrayList;
import java.util.List;

public class 하노이탑 {
    private List<int[]> result;

    public int[][] solution(int n) {
        result = new ArrayList<>();

        recursion(n,1,2,3);

        return result.stream()
                .toArray(int[][]::new);
    }

    private void recursion(int n, int start, int via, int end){
        if(n == 1){
            result.add(new int[]{start,end});
            return;
        }

        recursion(n - 1,start,end,via);

        result.add(new int[]{start,end});

        recursion(n-1,via,start,end);
    }
}
