package programmers.cumulative;

public class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] a = new int[N + 1][M + 1];
        for(int[] s : skill){
            int degree = s[0] == 1 ? -s[5] : s[5];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];

            a[r1][c1] += degree;
            a[r1][c2 + 1] -= degree;
            a[r2 + 1][c1] -= degree;
            a[r2 + 1][c2 + 1] += degree;
        }

        for(int j=0;j<M;j++){
            for(int i=1;i<N;i++){
                a[i][j] += a[i - 1][j];
            }
        }

        for(int i=0;i<N;i++){
            for(int j=1;j<M;j++){
                a[i][j] += a[i][j - 1];
            }
        }

        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                board[i][j] += a[i][j];
                if(board[i][j] > 0)
                    answer += 1;
            }
        }

        return answer;
    }
}
