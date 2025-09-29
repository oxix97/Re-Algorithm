package programmers.implement;

public class 쿼드압축후개수세기 {
    int[] answer = {0,0};
    int[][] arr;
    public int[] solution(int[][] arr) {
        this.arr = arr;
        recursion(0,0,arr.length);
        return answer;
    }

    private void recursion(int y,int x, int len){
        if(check(y,x,len)){
            answer[arr[y][x]] += 1;
        }else{
            int new_len = len / 2;
            recursion(y,x,new_len);
            recursion(y,x + new_len,new_len);
            recursion(y + new_len,x,new_len);
            recursion(y + new_len,x + new_len,new_len);
        }
    }

    private boolean check(int y, int x, int len){
        int v = arr[y][x];

        for(int i = y;i<y + len;i++){
            for(int j=x;j<x + len;j++){
                if(arr[i][j] != v){
                    return false;
                }
            }
        }

        return true;
    }
}
