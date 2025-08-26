package programmers.greedy;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int range = 1 + w * 2;
        int pos = 1;
        int answer = 0;
        for(int s : stations){
            int left = Math.max(1, s - w);
            int right = Math.min(n,s + w);
            int cnt = left - pos;
            if(cnt > 0){
                int v = cnt % range == 0 ? cnt / range : 1 + cnt / range;
                answer += v;
            }
            pos = right + 1;
        }
        if(pos <= n){
            int cnt = n - pos + 1;
            int v = cnt % range == 0 ? cnt / range : 1 + cnt / range;
            answer += v;
        }
        return answer;
    }
}
