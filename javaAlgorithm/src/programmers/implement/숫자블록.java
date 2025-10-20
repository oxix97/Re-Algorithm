package programmers.implement;

public class 숫자블록 {
    public int[] solution(long begin, long end) {
        int from = (int) begin;
        int to = (int) end;
        int len = to - from + 1;
        int[] answer = new int[len];
        for(int i=from;i<=to;i++){
            answer[i - from] = find(i);
        }
        if(from == 1)
            answer[0] = 0;

        return answer;
    }

    private int find(int n){
        int max = 1;
        for(int i = 2; i*i<=n;i++){
            if(n % i == 0){
                max = i;
                int div = n / i;
                if(div <= 10_000_000)
                    return div;
            }
        }

        return max;
    }
}
