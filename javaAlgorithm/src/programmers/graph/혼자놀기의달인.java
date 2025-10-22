package programmers.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 혼자놀기의달인 {
    public int solution(int[] cards) {
        int N = cards.length;
        int answer = 0;
        boolean[] visit = new boolean[N];
        List<Integer> group = new ArrayList<>();

        for(int i=0;i<N;i++){
            int idx = i;
            int count = 0;
            while(!visit[idx]){
                visit[idx] = true;
                idx = cards[idx] - 1;
                count += 1;
            }

            group.add(count);
        }

        Collections.sort(group,Collections.reverseOrder());

        return group.size() <= 1 ? 0 : group.get(0) * group.get(1);
    }
}
