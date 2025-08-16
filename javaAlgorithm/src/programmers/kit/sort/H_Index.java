package programmers.kit.sort;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for(int h = len;h >= 1;h--){
            if(citations[len - h] >= h){
                return h;
            }
        }

        return 0;
    }
}
