package programmers.implement;

public class n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left);
        int[] answer = new int[len + 1];
        int idx = 0;
        while(left <= right){
            int i = (int)(left / n);
            int j = (int)(left % n);
            answer[idx++] = Math.max(i + 1, j + 1);
            left += 1;
        }

        return answer;
    }
}
