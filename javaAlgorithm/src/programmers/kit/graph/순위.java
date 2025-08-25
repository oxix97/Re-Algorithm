package programmers.kit.graph;

public class 순위 {
    public int solution(int n, int[][] results) {
        boolean[][] rate = new boolean[n + 1][n + 1];

        for(int[] r : results){
            rate[r[0]][r[1]] = true;
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(rate[i][k] && rate[k][j]){
                        rate[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=1;j<=n;j++){
                if(rate[i][j] || rate[j][i]){
                    count += 1;
                }
            }
            if(count == n - 1){
                answer += 1;
            }
        }

        return answer;
    }
}
