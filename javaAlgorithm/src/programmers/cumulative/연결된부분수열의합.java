package programmers.cumulative;

public class 연결된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int left = 0;
        long sum = 0;
        int[] answer = {0,0};
        int min = Integer.MAX_VALUE;
        for(int right = 0;right<len;right++){
            sum += sequence[right];

            while(sum > k){
                sum -= sequence[left++];
            }

            if(sum == k){
                int current = right - left + 1;

                if(current < min){
                    min = current;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        return answer;
    }
}
