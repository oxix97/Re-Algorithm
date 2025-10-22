package programmers.backtracking;

public class 양궁대회 {
    int[] result;
    int maxPoint = 0;
    int[] answer;
    public int[] solution(int n, int[] info) {
        result = new int[info.length];
        answer = new int[info.length];

        recursion(0,n,info);

        if(maxPoint == 0)
            return new int[] {-1};

        return answer;
    }

    private void recursion(int idx, int n, int[] info){
        if(idx == 11){
            result[10] += n;
            int apeach = 0;
            int rion = 0;
            for(int i=0;i<10;i++){
                int point = 10 - i;
                if(result[i] > info[i])
                    rion += point;
                else if(info[i] > 0)
                    apeach += point;
            }

            int diff = rion - apeach;
            if(diff > maxPoint){
                answer = result.clone();
                maxPoint = diff;
            }else if(diff == maxPoint){
                for(int i=10;i >=0;i--){
                    if(result[i] > answer[i]){
                        answer = result.clone();
                        break;
                    }else if(result[i] < answer[i]){
                        break;
                    }
                }
            }

            result[10] -= n;
            return;
        }

        int cost = info[idx] + 1;
        if(cost <= n){
            result[idx] = cost;
            recursion(idx + 1,n - cost,info);
            result[idx] = 0;
        }

        recursion(idx + 1, n, info);
    }
}
