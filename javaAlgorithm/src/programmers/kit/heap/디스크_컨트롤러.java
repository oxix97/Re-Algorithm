package programmers.kit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs,(o1, o2)->o1[0] - o2[0]);
        int total_time  = 0;
        int time = 0;
        int count = 0;
        int i = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>();

        while (count < jobs.length){
            while(i < jobs.length && jobs[i][0] <= time){
                pq.add(new Job(i,jobs[i][0],jobs[i][1]));
                i += 1;
            }

            if(!pq.isEmpty()){
                Job job = pq.poll();
                time += job.duration;
                total_time += time - job.request_time;
                count += 1;
            }else{
                time = jobs[i][0];
            }
        }

        return total_time / jobs.length;
    }

    class Job implements Comparable<Job>{
        int num;
        int request_time;
        int duration;

        public Job (int n, int q, int d){
            this.num = n;
            this.request_time = q;
            this.duration = d;
        }

        @Override
        public int compareTo(Job o){
            if(o.duration == this.duration){
                if(o.request_time == this.request_time){
                    return this.num - o.num;
                }
                return this.request_time - o.request_time;
            }
            return this.duration - o.duration;
        }
    }
}
