package book.implementation;

public class 게임개발 {
    public static void main(String[] args) {
        //input
        int N = 4;
        int M = 4;
        int y = 1;
        int x = 1;
        int dir = 0;

        int[][] arr = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };
        int answer = 1;
        arr[y][x] = 1;

        // 북, 동, 남, 서
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int turn = 0;

        while (true) {
            dir = (dir + 3) % 4; //왼쪽으로 방향 회천
            while (true) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (!outOfRange(ny, nx, N, M) && arr[ny][nx] == 0) {
                    arr[ny][nx] = 1;
                    y = ny;
                    x = nx;
                    ++answer;
                    turn = 0;
                } else { // 범위에서 벗어난 경우 && 전진할 수 없는 경우
                    turn++;
                    break;
                }
            }
            if (turn == 4) { // 반시계 방향으로 회전을 모두 마친 경우
                int back = (dir + 2) % 4;
                int ny = y + dy[back];
                int nx = x + dx[back];

                if (outOfRange(ny, nx, N, M) || arr[ny][nx] == 1) break; // 종료 조건
                y = ny;
                x = nx;
                turn = 0;
            }
        }

        System.out.println(answer);
    }

    private static boolean outOfRange(int y, int x, int n, int m) {
        return y >= n || x >= m || y < 0 || x < 0;
    }
}
