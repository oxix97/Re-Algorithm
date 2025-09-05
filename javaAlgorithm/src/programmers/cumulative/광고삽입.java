package programmers.cumulative;

public class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = stringToNum(play_time);
        int adv = stringToNum(adv_time);
        long[] t = new long[play + 1];

        for(String log : logs){
            String[] l = log.split("-");
            int start = stringToNum(l[0]);
            int end = stringToNum(l[1]);

            t[start] += 1;
            t[end] -= 1;
        }

        for(int i=1;i<=play;i++){
            t[i] += t[i - 1];
        }
        for(int i=1;i<=play;i++){
            t[i] += t[i - 1];
        }

        int start = 0;
        long max = t[adv - 1];
        for(int i=adv;i<=play;i++){
            long current = t[i] - t[i - adv];
            if(max < current){
                max = current;
                start = i - adv + 1;
            }
        }

        return numToString(start);
    }

    private int stringToNum(String time){
        String[] str = time.split(":");
        int a = Integer.parseInt(str[0]) * 60 * 60;
        int b = Integer.parseInt(str[1]) * 60;
        int c = Integer.parseInt(str[2]);
        return a + b +c;
    }

    private String numToString(int time){
        int h = time / 3600;
        int m = (time % 3600) / 60;
        int s = time % 60;
        return String.format("%02d:%02d:%02d",h,m,s);
    }
}
