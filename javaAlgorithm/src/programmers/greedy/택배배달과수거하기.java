package programmers.greedy;

public class 택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int i = -1;
        int j = -1;
        for(int k=0;k<n;k++){
            if(deliveries[k] > 0)
                i = k;
            if(pickups[k] > 0)
                j = k;
        }
        while(i >= 0 || j >= 0){
            int from = move(cap,i,deliveries);
            int to = move(cap,j,pickups);

            answer += Math.max(i + 1,j + 1) * 2L;

            i = from;
            j = to;
        }

        return answer;
    }

    private int move (int cap, int i, int[] target){
        while(i >= 0){
            if(cap - target[i] >= 0){
                cap -= target[i];
                target[i] = 0;
                i--;
            }else{
                target[i] -= cap;
                break;
            }
        }

        return i;
    }
}
