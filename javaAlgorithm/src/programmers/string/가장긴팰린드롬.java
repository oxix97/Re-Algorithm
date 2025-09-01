package programmers.string;

public class 가장긴팰린드롬 {
    int N;
    public int solution(String s) {
        N = s.length();
        int answer = 1;
        for(int i=0;i<N;i++){
            int a = palindrome(s,i,i);
            int b = palindrome(s,i,i + 1);
            answer = Math.max(answer,Math.max(a,b));
        }

        return answer;
    }

    private int palindrome(String s, int left, int right){
        while(0 <= left && right < N && s.charAt(left) == s.charAt(right)){
            left -= 1;
            right += 1;
        }

        return right - left - 1;
    }
}
