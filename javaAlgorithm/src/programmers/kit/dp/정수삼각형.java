package programmers.kit.dp;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int len = triangle.length - 2;
        for(int i=len;i >= 0;i--){
            for(int j=0;j<triangle[i].length;j++){
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }
}
