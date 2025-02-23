import sys
from collections import defaultdict, deque

input = sys.stdin.readline
dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]
M, N = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(N)]


def range_correct(ny, nx):
    return 0 <= ny < N and 0 <= nx < M


def valid_tomato(ny, nx):
    return box[ny][nx] == 0


def bfs():
    q = deque()
    # 익은 토마토를 q에 담는다. -> (토마토 idx, 날짜)
    for i in range(N):
        for j in range(M):
            if box[i][j] == 1:
                q.append((i, j))

    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if range_correct(ny, nx) and valid_tomato(ny, nx):
                box[ny][nx] = box[y][x] + 1
                q.append((ny, nx))

    answer = 0
    for line in box:
        max_value = max(line)
        if line.count(0) >= 1:
            print(-1)
            return
        answer = max(answer, max_value)
    print(answer - 1)


if __name__ == '__main__':
    bfs()
