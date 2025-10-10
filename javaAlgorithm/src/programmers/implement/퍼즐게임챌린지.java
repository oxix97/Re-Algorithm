package programmers.implement;

public class 퍼즐게임챌린지 {
    final int MAX = 100_000;
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = MAX;
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(play(mid, limit,diffs,times)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean play(int level,long limit, int[] diffs, int[] times){
        long total = times[0];
        int prev = times[0];

        for(int i=1;i<diffs.length;i++){
            int cur = times[i];

            if(level < diffs[i]){
                cur += (cur + prev) * (diffs[i] - level);
            }

            prev = times[i];
            total += cur;

            if(total > limit)
                return false;

        }

        return true;
    }
}
