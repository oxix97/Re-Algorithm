package programmers.kit.brute_force;

public class 피로도 {
    public int solution(int k, int[][] dungeons) {
        boolean[] visit = new boolean[dungeons.length];
        return recursion(k,dungeons,visit);
    }

    private int recursion(int k, int[][] dungeons, boolean[] visit){
        int max = 0;
        for(int i=0;i<visit.length;i++){
            if(!visit[i] && k >= dungeons[i][0]){
                visit[i] = true;
                max = Math.max(max,1 + recursion(k - dungeons[i][1],dungeons,visit));
                visit[i] = false;
            }
        }
        return max;
    }
}
