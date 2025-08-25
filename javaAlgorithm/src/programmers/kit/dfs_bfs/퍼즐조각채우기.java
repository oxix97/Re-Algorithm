package programmers.kit.dfs_bfs;

import java.util.*;

public class 퍼즐조각채우기 {
    int N;
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};
    public int solution(int[][] game_board, int[][] table) {
        N = table.length;
        List<Puzzle> empty = find(game_board,0);
        List<Puzzle> puzzle = find(table,1);
        boolean[] visit = new boolean[puzzle.size()];
        int answer = 0;

        for(Puzzle em : empty){
            boolean match = false;

            for(int i=0;i<puzzle.size();i++){
                if(visit[i])
                    continue;

                Puzzle p = puzzle.get(i);
                if(em.pieces.size() != p.pieces.size())
                    continue;

                for(int j=0;j<4;j++){
                    if(em.isSame(p)){
                        answer += p.pieces.size();
                        visit[i] = true;
                        match = true;
                        break;
                    }

                    p = p.rotate();
                }

                if(match)
                    break;
            }
        }

        return answer;
    }

    public List<Puzzle> find(int[][] arr, int target){
        List<Puzzle> puzzle = new ArrayList<>();
        boolean[][] visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j] && arr[i][j] == target){
                    List<Piece> pieces = new ArrayList<>();
                    Deque<int[]> q = new ArrayDeque<>();
                    visit[i][j] = true;
                    q.addLast(new int[]{i,j});
                    pieces.add(new Piece(i,j));

                    while(!q.isEmpty()){
                        int[] now = q.removeFirst();
                        for(int k=0;k<4;k++){
                            int y = now[0] + dy[k];
                            int x = now[1] + dx[k];

                            if(0 <= y && y < N && 0 <= x && x < N && !visit[y][x] && arr[y][x] == target){
                                visit[y][x] = true;
                                q.addLast(new int[]{y,x});
                                pieces.add(new Piece(y,x));
                            }
                        }
                    }
                    puzzle.add(new Puzzle(pieces).normalize());
                }
            }
        }
        return puzzle;
    }

    class Puzzle {
        public List<Piece> pieces;

        public Puzzle(List<Piece> pieces){
            this.pieces = pieces;
        }

        public Puzzle normalize(){
            int r = 51;
            int c = 51;
            for(Piece p : pieces){
                r = Math.min(r,p.y);
                c = Math.min(c,p.x);
            }

            List<Piece> result = new ArrayList<>();
            for(Piece p : pieces){
                result.add(new Piece(p.y - r, p.x - c));
            }

            Collections.sort(result);

            return new Puzzle(result);
        }

        public Puzzle rotate(){
            List<Piece> result = new ArrayList<>();

            for(Piece p : pieces){
                result.add(new Piece(p.x, -p.y));
            }

            return new Puzzle(result).normalize();
        }

        public boolean isSame(Puzzle other){
            for(int i=0;i<this.pieces.size();i++){
                Piece p1 = this.pieces.get(i);
                Piece p2 = other.pieces.get(i);
                if(p1.y != p2.y || p1.x != p2.x){
                    return false;
                }
            }
            return true;
        }
    }

    class Piece implements Comparable<Piece>{
        int y;
        int x;

        public Piece (int y, int x){
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Piece o){
            if(this.y == o.y){
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }
}
