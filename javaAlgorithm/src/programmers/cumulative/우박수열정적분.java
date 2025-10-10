package programmers.cumulative;

import java.util.ArrayList;
import java.util.List;

public class 우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> result = new ArrayList<>();
        result.add(k);
        while(k != 1){
            if(k % 2 == 0){
                k /= 2;
            }else{
                k = 1 + k * 3;
            }
            result.add(k);
        }

        int n = result.size() - 1;
        double[] sum = new double[n + 1];
        double[] psum = new double[n + 1];
        for(int i=1;i<result.size();i++){
            double v = calculate(i-1,result.get(i-1),i,result.get(i));
            sum[i] = v;
            psum[i] = psum[i - 1] + v;
        }

        double[] answer = new double[ranges.length];
        for(int i=0;i<ranges.length;i++){
            int a = ranges[i][0];
            int b = n + ranges[i][1];

            if(a > b){
                answer[i] = -1;
            }else{
                answer[i] = psum[b] - psum[a];
            }
        }

        return answer;
    }

    private double calculate(int x1, int y1, int x2, int y2){
        double h = x2 - x1;
        double w = y1 + y2;

        return w * h / 2;
    }
}
