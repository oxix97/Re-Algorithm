package programmers.graph;

import java.util.PriorityQueue;

public class 미로탈출명령어 {
    int N;
    int M;
    int[] dx = {1,0,0,-1};
    int[] dy = {0,-1,1,0};
    String[] ds = {"d","l","r","u"};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.N = n;
        this.M = m;
        boolean[][][] visit = new boolean[n + 1][m + 1][k + 1];
        visit[x][y][0] = true;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(x,y,"",0));
        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                String ns = now.s + ds[i];
                int nd = now.dist + 1;

                if(ny == c && nx == r && nd == k){
                    return ns;
                }

                if(check(nx,ny) && nd < k && !visit[nx][ny][nd]){
                    q.add(new Node(nx,ny,ns,nd));
                    visit[nx][ny][nd] = true;
                }
            }
        }

        return "impossible";
    }

    private boolean check(int x, int y){
        return 1 <= y && y <= M && 1 <= x && x <= N;
    }

    class Node implements Comparable<Node>{
        int x;
        int y;
        String s;
        int dist;
        public Node(int x, int y, String s,int d){
            this.y = y;
            this.x = x;
            this.s=s;
            this.dist = d;
        }

        @Override
        public int compareTo(Node o){
            if(this.dist == o.dist){
                return this.s.compareTo(o.s);
            }
            return this.dist - o.dist;
        }
    }
}
