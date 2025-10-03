package programmers.implement;

public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows + 1][columns + 1];
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                arr[i][j] = columns * (i - 1) + j;
            }
        }

        int idx = 0;
        for(int[] q : queries){
            int y1 = q[0];
            int x1 = q[1];
            int y2 = q[2];
            int x2 = q[3];
            int tmp = arr[y1][x1];
            int min = tmp;

            for(int i=y1;i<y2; i++){
                int v = arr[i + 1][x1];
                arr[i][x1] = v;
                min = Math.min(min,v);
            }

            for(int i=x1;i<x2;i++){
                int v = arr[y2][i + 1];
                arr[y2][i] = v;
                min = Math.min(min,v);
            }

            for(int i=y2;i>y1;i--){
                int v = arr[i - 1][x2];
                arr[i][x2] = v;
                min = Math.min(min,v);
            }

            for(int i=x2;i>x1;i--){
                int v = arr[y1][i - 1];
                arr[y1][i] = v;
                min = Math.min(min,v);
            }

            arr[y1][x1 + 1] = tmp;
            answer[idx++] = min;
        }

        return answer;
    }
}
