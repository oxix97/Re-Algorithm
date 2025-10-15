package programmers.brute_force;

public class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;

        for(int x = 0; x<= d; x+= k){
            long maxY = (long) Math.sqrt(Math.pow(d,2.0) - Math.pow(x,2.0));
            answer += (maxY / k) + 1;
        }

        return answer;
    }
}
