package programmers.kit.dfs_bfs;

import java.util.*;

public class 여행경로 {
    Map<String, PriorityQueue<String>> map;
    List<String> answer;
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        answer = new ArrayList<>();
        for(String[] t : tickets){
            map.computeIfAbsent(t[0], k -> new PriorityQueue<>()).add(t[1]);
        }
        dfs("ICN");
        Collections.reverse(answer);
        return answer.toArray(String[]::new);
    }

    public void dfs(String from){
        PriorityQueue<String> pq = map.get(from);
        while(pq != null && !pq.isEmpty()){
            String to = map.get(from).poll();
            dfs(to);
        }
        answer.add(from);
    }
}
