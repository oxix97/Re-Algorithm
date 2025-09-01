package programmers.greedy;

import java.util.Arrays;

public class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = Arrays.stream(timetable)
                .map(it->{
                    String[] time = it.split(":");
                    return Integer.parseInt(time[1]) + Integer.parseInt(time[0]) * 60;
                })
                .mapToInt(it->it)
                .sorted()
                .toArray();

        int idx = 0;
        int bus = 9 * 60;
        int last = 0;
        for(int i=0;i<n;i++){
            int cnt = 0;
            while(idx < times.length && times[idx] <= bus && cnt < m){
                if(i == n - 1)
                    last = times[idx];
                idx += 1;
                cnt += 1;
            }

            if(i == n - 1){
                if(cnt < m){
                    return format(bus);
                }else{
                    return format(last - 1);
                }
            }

            bus += t;
        }

        return "";
    }

    private String format(int time){
        return String.format("%02d:%02d",time / 60, time % 60);
    }
}
