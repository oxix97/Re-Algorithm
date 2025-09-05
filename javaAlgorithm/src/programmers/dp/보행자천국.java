package programmers.dp;

public class 보행자천국 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dist = new int[m][n][2];
        for(int j=0;j<n;j++){
            if(cityMap[0][j] == 1)
                break;
            dist[0][j][1] = 1;
        }
        for(int i=0;i<m;i++){
            if(cityMap[i][0] == 1)
                break;
            dist[i][0][0] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(cityMap[i][j] == 1)
                    continue;

                if(cityMap[i - 1][j] == 0){
                    dist[i][j][0] = (dist[i - 1][j][0] + dist[i - 1][j][1]) % MOD;
                }else if(cityMap[i - 1][j] == 2){
                    dist[i][j][0] = dist[i - 1][j][0];
                }
                if(cityMap[i][j - 1] == 0){
                    dist[i][j][1] = (dist[i][j - 1][0] + dist[i][j - 1][1]) % MOD;
                }else if(cityMap[i][j - 1] == 2){
                    dist[i][j][1] = dist[i][j - 1][1];
                }
            }
        }

        return (dist[m - 1][n - 1][0] + dist[m - 1][n - 1][1]) % MOD;
    }
}
