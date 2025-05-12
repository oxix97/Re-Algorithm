import sys
from collections import deque


def main():
    def range_ex(y, x):
        return y < 0 or y >= N or x < 0 or x >= M

    def bfs(i, j):
        q = deque()
        q.append((i, j))
        visited[i][j] = True
        width = 1
        while q:
            y, x = q.popleft()
            for n in range(4):
                ny = dy[n] + y
                nx = dx[n] + x
                if range_ex(ny, nx) or visited[ny][nx] or A[ny][nx] == 0: continue
                q.append((ny,nx))
                visited[ny][nx] = True
                width += 1
        return width


    input = sys.stdin.readline
    N, M = map(int, input().split())
    dy = [1, 0, -1, 0]
    dx = [0, 1, 0, -1]
    A = []
    for i in range(N):
        A.append(list(map(int, input().split())))
    visited = [[False for _ in range(M)] for _ in range(N)]
    count = 0
    max_width = 0
    for i in range(N):
        for j in range(M):
            if not visited[i][j] and A[i][j] == 1:
                count += 1
                max_width = max(max_width,bfs(i, j))

    print(count)
    print(max_width)


if __name__ == '__main__':
    main()
