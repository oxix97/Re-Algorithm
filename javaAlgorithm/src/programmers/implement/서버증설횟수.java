package programmers.implement;

public class 서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        for(int i=0;i<players.length;i++){
            int player = players[i];
            int capacity = (server[i] + 1) * m;
            if(player >= capacity){
                int need = 1 + (player-capacity) / m;
                answer += need;
                for(int j=i;j<i+k && j<24;j++)
                    server[j] += need;
            }
        }

        return answer;
    }
}
