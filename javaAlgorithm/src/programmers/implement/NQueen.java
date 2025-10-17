package programmers.implement;

public class NQueen {
    int N;
    int answer = 0;
    int[] arr;
    public int solution(int n) {
        N = n;
        arr = new int[n];
        dfs(0);

        return answer;
    }

    private void dfs(int row){
        if(row == N){
            answer += 1;
            return;
        }

        for(int i=0;i<N;i++){
            arr[row] = i;

            if(check(row))
                dfs(row + 1);
        }
    }

    private boolean check(int row){
        for(int i=0;i<row;i++){
            if(arr[i] == arr[row])
                return false;
            if(Math.abs(row - i) == Math.abs(arr[row] - arr[i]))
                return false;
        }
        return true;
    }
}
