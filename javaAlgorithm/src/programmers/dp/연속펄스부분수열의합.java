package programmers.dp;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        int N = sequence.length;
        long answer = Long.MIN_VALUE;
        long[][] dp = new long[N][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];

        if(N == 1){
            return Math.abs(sequence[0]);
        }

        for(int i=1;i<N;i++){
            if(i % 2 == 0){
                dp[i][0] = Math.max(dp[i - 1][0] + sequence[i],sequence[i]);
                dp[i][1] = Math.max(dp[i - 1][1] - sequence[i], -sequence[i]);
            }else{
                dp[i][0] = Math.max(dp[i - 1][0] - sequence[i], -sequence[i]);
                dp[i][1] = Math.max(dp[i - 1][1] + sequence[i], sequence[i]);
            }
            answer = Math.max(answer,Math.max(dp[i][0],dp[i][1]));
        }

        return answer;
    }
}
