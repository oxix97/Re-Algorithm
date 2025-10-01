package programmers.greedy;

public class 마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int rem = storey % 10;
            int next = (storey / 10) % 10;

            if(rem > 5){
                answer += 10 - rem;
                storey += 10;
            }else if(rem == 5){
                answer += 5;
                if(next >= 5){
                    storey += 10;
                }
            }else{
                answer += rem;
            }
            storey /= 10;
        }
        return answer;
    }
}
