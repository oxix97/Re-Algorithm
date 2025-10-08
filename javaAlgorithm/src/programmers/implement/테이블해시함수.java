package programmers.implement;

import java.util.Arrays;

public class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data,(a, b)->{
            if(a[col - 1] == b[col - 1]){
                return b[0] - a[0];
            }
            return a[col - 1] - b[col - 1];
        });

        int[] result = new int[data.length];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                result[i] += data[i][j] % (i + 1);
            }
        }

        int answer = 0;
        for(int i=row_begin-1;i<row_end;i++){
            answer ^= result[i];
        }

        return answer;
    }
}
