package programmers.implement;

public class 프렌즈4블록 {
    int[] dy = {0,1,1};
    int[] dx = {1,0,1};
    char[][] board;
    int m;
    int n;

    public int solution(int m, int n, String[] board) {
        this.board = new char[m][n];
        this.m = m;
        this.n = n;
        for(int i=0;i<m;i++){
            this.board[i] = board[i].toCharArray();
        }
        int answer = 0;
        while(true){
            int result = recursion();
            if(result == 0)
                break;
            answer += result;
        }
        return answer;
    }

    private int recursion(){
        boolean[][] visit = new boolean[m][n];
        for(int y=0;y< m - 1;y++){
            for(int x=0;x<n - 1;x++){
                boolean eq = true;
                if(board[y][x] == ' ')
                    continue;
                for(int k=0;k<3;k++){
                    int ny = dy[k] + y;
                    int nx = dx[k] + x;
                    if(board[y][x] != board[ny][nx]){
                        eq = false;
                        break;
                    }
                }
                if(eq){
                    visit[y][x] = true;
                    for(int k=0;k<3;k++){
                        int ny = dy[k] + y;
                        int nx = dx[k] + x;
                        visit[ny][nx] = true;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                if(visit[i][j]){
                    answer += 1;
                    board[i][j] = ' ';
                }
        }

        for(int i = m - 2;i >= 0;i--){
            for(int j=0;j<n;j++){
                int h = i + 1;
                boolean eq = false;
                while(h < m && board[h][j] == ' '){
                    h++;
                    eq = true;
                }
                if(eq){
                    board[h - 1][j] = board[i][j];
                    board[i][j] = ' ';
                }
            }
        }
        return answer;
    }
}
