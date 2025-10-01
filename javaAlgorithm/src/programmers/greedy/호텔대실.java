package programmers.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 호텔대실 {
    public int solution(String[][] book_time) {
        List<Time> times = Arrays.stream(book_time)
                .map(it->{
                    String[] s = it[0].split(":");
                    String[] e = it[1].split(":");
                    int start = Integer.parseInt(s[1]) + Integer.parseInt(s[0]) * 60;
                    int end = Integer.parseInt(e[1]) + Integer.parseInt(e[0]) * 60;
                    return new Time(start,end);
                })
                .sorted()
                .collect(Collectors.toList());

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(Time t : times){
            while(!pq.isEmpty() && t.start >= pq.peek() + 10)
                pq.poll();

            pq.add(t.end);
            answer = Math.max(answer,pq.size());
        }

        return answer;
    }

    class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o){
            if(this.start == o.start){
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
