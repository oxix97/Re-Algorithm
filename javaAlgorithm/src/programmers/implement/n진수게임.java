package programmers.implement;

public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=t*m;i++){
            sb.append(Integer.toString(i,n));
        }

        StringBuilder answer = new StringBuilder();
        int pos = 0;
        while(t > 0){
            if(1 + pos % m == p){
                answer.append(sb.substring(pos,pos + 1));
                t -= 1;
            }
            pos += 1;
        }

        return answer.toString().toUpperCase();
    }
}
