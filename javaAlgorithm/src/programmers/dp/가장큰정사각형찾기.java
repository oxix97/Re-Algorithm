package programmers.dp;

public class 가장큰정사각형찾기 {
    public int solution(int [][]board){
        int N = board.length;
        int M = board[0].length;
        int[][] dp = new int[N + 1][M + 1];

        int answer = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(board[i - 1][j - 1] == 1){
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min,dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                    answer = Math.max(answer,dp[i][j]);
                }
            }
        }

        return answer * answer;
    }
}
