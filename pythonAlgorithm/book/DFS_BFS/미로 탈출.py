import sys
from collections import deque


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    A = [list(input().strip()) for _ in range(N)]
    q = deque()
    dist = [[0 for _ in range(M)] for _ in range(N)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    q.append((0, 0))
    dist[0][0] = 1
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < N and 0 <= ny < M and A[nx][ny] == '1' and dist[nx][ny] == 0:
                q.append((nx, ny))
                dist[nx][ny] = dist[x][y] + 1

    print(dist[N - 1][M - 1])

if __name__ == '__main__':
    main()
