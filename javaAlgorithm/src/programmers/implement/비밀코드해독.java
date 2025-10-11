package programmers.implement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 비밀코드해독 {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int len = q.length;
        List<List<Integer>> result = new ArrayList<>();

        combination(n,0,new ArrayList<Integer>(),result);

        for(List<Integer> comb : result){
            boolean decode = true;

            for(int i=0;i<len;i++){
                if(decry(comb, q[i]) != ans[i]){
                    decode = false;
                    break;
                }
            }

            if(decode)
                answer += 1;
        }

        return answer;
    }

    private int decry(List<Integer> enc, int[] quest){
        Set<Integer> set = new HashSet(enc);
        for(int i=0;i<5;i++){
            set.add(quest[i]);
        }

        return 10 - set.size();
    }

    private void combination(int n, int pre, List<Integer> tmp, List<List<Integer>> result){
        if(tmp.size() == 5){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }

        for(int i=pre + 1;i<=n;i++){
            tmp.add(i);
            combination(n,i,tmp,result);
            tmp.remove(tmp.size() - 1);
        }
    }
}
