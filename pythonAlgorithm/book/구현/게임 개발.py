import sys

def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    x, y, d = map(int, input().split())
    field = [list(map(int, input().split())) for _ in range(N)]

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    visited = [[False for _ in range(M)] for _ in range(N)]
    visited[x][y] = True
    answer = 1

    while True:
        move = False
        for _ in range(4):
            d = (d + 3) % 4
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < N and 0 <= ny < M and field[nx][ny] == 0 and not visited[nx][ny]:
                visited[nx][ny] = True
                x, y = nx, ny
                answer += 1
                move = True
                break

        if not move:
            nx = x - dx[d]
            ny = y - dy[d]
            if nx < 0 or nx >= N or ny < 0 or ny >= M or field[nx][ny] == 1:
                break
            x, y = nx, ny

    print(answer)


if __name__ == '__main__':
    main()
