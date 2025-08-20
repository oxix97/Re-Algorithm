package programmers.kit.dp;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n + 1][m + 1];
        boolean[][] puddle = new boolean[n + 1][m + 1];
        for(int[] p : puddles){
            puddle[p[1]][p[0]] = true;
        }
        for(int i=1;i<=n;i++){
            if(puddle[i][1]) break;
            arr[i][1] = 1;
        }
        for(int i=1;i<=m;i++){
            if(puddle[1][i]) break;
            arr[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=m;j++){
                if(puddle[i][j])
                    continue;
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                arr[i][j] %= 1_000_000_007;

            }
        }
        return arr[n][m];
    }
}
