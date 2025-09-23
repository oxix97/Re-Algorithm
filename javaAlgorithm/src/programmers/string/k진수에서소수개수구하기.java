package programmers.string;

public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        String s = Integer.toString(n,k);
        int answer = 0;
        int left = 0;
        int right = 0;
        while(left < s.length() && right < s.length()){
            while(right < s.length() && s.charAt(right) != '0')
                right += 1;

            long num = Long.parseLong(s.substring(left,right));
            if(num > 1 && isPrime(num)){
                answer += 1;
            }

            left = right;
            right += 1;
        }

        return answer;
    }

    private boolean isPrime(long n){
        int sq = (int) Math.sqrt(n);
        for(int i=2;i<=sq;i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
