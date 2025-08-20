package programmers.kit.dfs_bfs;

public class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,target,0,0);
    }

    private int dfs(int[] numbers, int target, int idx, int v){
        if(idx == numbers.length){
            return v == target ? 1 : 0;
        }

        int add = dfs(numbers,target,idx + 1,v + numbers[idx]);
        int subtract = dfs(numbers,target,idx + 1,v - numbers[idx]);

        return add + subtract;
    }
}
