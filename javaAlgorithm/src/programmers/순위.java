package programmers;

class 순위 {
    public int solution(int n, int[][] results) {
        int[][] floyd = new int[n + 1][n + 1];
        for(int[] result : results){
            int a = result[0];
            int b = result[1];
            floyd[a][b] = 1;
            floyd[b][a] = -1;
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(floyd[k][i] == 1 && floyd[i][j] == 1){
                        floyd[k][j] = 1;
                        floyd[j][k] = -1;
                    }
                    if(floyd[k][i]==-1 && floyd[i][j] == -1){
                        floyd[k][j] = -1;
                        floyd[j][k] = 1;
                    }
                }
            }
        }
        int answer = 0;
        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=1;j<=n;j++) if(floyd[i][j]==0) ++cnt;
            if(cnt==1) answer++;
        }
        
        return answer;
    }
}