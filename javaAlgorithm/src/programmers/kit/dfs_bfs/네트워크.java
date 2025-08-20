package programmers.kit.dfs_bfs;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                answer += 1;
                dfs(computers,visit,i);
            }
        }
        return answer;
    }

    public void dfs(int[][] computers, boolean[] visit, int n){
        visit[n] = true;
        for(int i=0;i<visit.length;i++){
            if(!visit[i] && computers[n][i] == 1){
                dfs(computers, visit, i);
            }
        }
    }
}
