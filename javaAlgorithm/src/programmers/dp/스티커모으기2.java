package programmers.dp;

public class 스티커모으기2 {
    public int solution(int sticker[]) {
        int len = sticker.length;
        if(len <= 3){
            int answer = 0;
            for(int i=0;i<len;i++){
                answer = Math.max(answer,sticker[i]);
            }
            return answer;
        }

        int[] s1 = new int[len];
        s1[0] = sticker[0];
        s1[1] = sticker[0];
        for(int i=2;i<len - 1;i++){
            s1[i] = Math.max(s1[i - 1], s1[i - 2] + sticker[i]);
        }

        int[] s2 = new int[len];
        s2[1] = sticker[1];
        for(int i=2;i<len;i++){
            s2[i] = Math.max(s2[i - 1],s2[i - 2] + sticker[i]);
        }

        return Math.max(s1[len - 2], s2[len - 1]);
    }
}
