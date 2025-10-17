package programmers.implement;

import java.util.*;
import java.util.stream.Collectors;

public class 과제진행하기 {
    public String[] solution(String[][] plans) {
        List<Subject> subs = Arrays.stream(plans)
                .map(Subject::new)
                .sorted()
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();

        Deque<Subject> q = new ArrayDeque<>();
        for(int i=0;i<plans.length;i++){
            Subject now = subs.get(i);
            StringBuilder sb = new StringBuilder();
            if(i < subs.size() - 1){
                int next = subs.get(i + 1).start;
                int spend = next - now.start;
                if(now.remain > spend){
                    now.remain -= spend;
                    q.addLast(now);
                }else{
                    result.add(now.name);
                    int left = spend - now.remain;
                    while(!q.isEmpty() && left > 0){
                        Subject pre = q.removeLast();
                        if(pre.remain > left){
                            pre.remain -= left;
                            q.addLast(pre);
                            break;
                        }else{
                            left -= pre.remain;
                            result.add(pre.name);
                        }
                    }

                }
            }else{
                q.addLast(subs.get(i));
            }
        }

        while(!q.isEmpty())
            result.add(q.removeLast().name);

        return result.stream()
                .toArray(String[]::new);
    }

    class Subject implements Comparable<Subject>{
        String name;
        int start;
        int remain;

        public Subject(String[] plan){
            String[] h = plan[1].split(":");
            this.name = plan[0];
            this.start = Integer.parseInt(h[1]) + Integer.parseInt(h[0]) * 60;
            this.remain = Integer.parseInt(plan[2]);
        }

        @Override
        public int compareTo(Subject o){
            return this.start - o.start;
        }
    }
}
