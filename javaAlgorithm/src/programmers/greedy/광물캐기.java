package programmers.greedy;

import java.util.PriorityQueue;

public class 광물캐기 {
    public static void main(String[] args) {
        int answer = solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
        System.out.println(answer);
    }
    public static int solution(int[] picks, String[] minerals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2-o1);
        int seq = (minerals.length / 5) + (minerals.length % 5);

        for(int s=0;s<seq;s++){
            int idx = s * 5;
            int sum = 0;
            for(int i = idx; i < idx + 5 && i < minerals.length;i++){
                if(minerals[i].equals("diamond"))
                    sum += 25;
                else if(minerals[i].equals("iron"))
                    sum += 5;
                else
                    sum += 1;
            }
            pq.add(sum);
        }

        int cnt = picks[0] + picks[1] + picks[2];
        int answer = 0;
        while(cnt-- > 0 && !pq.isEmpty()){
            int n = pq.poll();
            if(picks[0] > 0){
                answer += 5;
                picks[0] -= 1;
                continue;
            }
            if(picks[1] > 0){
                int iron = n / 5;
                int stone = n % 5;
                answer += iron + stone;
                picks[1] -= 1;
                continue;
            }
            answer += n;
            picks[2] -= 1;
        }

        return answer;
    }
}
