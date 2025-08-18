package programmers.kit.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for (int lo : lost) {
            boolean isBoth = false;
            for (int re : reserve) {
                if (lo == re) {
                    isBoth = true;
                    break;
                }
            }
            if (!isBoth) lostList.add(lo);
        }
        for (int re : reserve) {
            boolean isBoth = false;
            for (int lo : lost) {
                if (lo == re) {
                    isBoth = true;
                    break;
                }
            }
            if (!isBoth) reserveList.add(re);
        }

        int answer = n - lostList.size();
        for (int lo : lostList) {
            if (reserveList.contains(lo - 1)) {
                reserveList.remove(Integer.valueOf(lo - 1));
                answer++;
            } else if (reserveList.contains(lo + 1)) {
                reserveList.remove(Integer.valueOf(lo + 1));
                answer++;
            }
        }

        return answer;
    }
}
