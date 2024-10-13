package org.example.programmers;

import java.util.*;
class 가장먼노드 {
    //1번 노트에서 가장 멀리 떨어진 노드의 개수를 구하기
    public int solution(int n, int[][] edge) {
        //1. List[]에 정보 담기
        List<Integer>[] list = new ArrayList[n + 1];
        for(int i=1;i<=n;i++) list[i] = new ArrayList<Integer>();
        for(int i=0;i<edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        //2. Queue 생성
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        //3. dist로 방문 여부 확인 및 기록
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if(dist[next] == -1){
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        Arrays.sort(dist);
        int answer = 1;
        for(int i = n; i > 1;i--){
            if(dist[i] != dist[i - 1]) break;
            ++answer;
        }
        return answer;
    }
}