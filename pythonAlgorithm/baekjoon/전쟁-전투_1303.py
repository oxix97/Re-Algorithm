import sys
from collections import deque

if __name__ == '__main__':

    def range_ex(y, x):
        return y < 0 or x < 0 or y >= M or x >= N

    def bfs(i, j, visited):
        q = deque()
        q.append((i, j))
        visited[i][j] = True
        dy = [1, 0, -1, 0]
        dx = [0, 1, 0, -1]
        count = 1
        while q:
            y, x = q.popleft()
            for idx in range(4):
                ny = y + dy[idx]
                nx = x + dx[idx]
                if range_ex(ny, nx) or visited[ny][nx]: continue
                if arr[i][j] == arr[ny][nx]:
                    q.append((ny, nx))
                    visited[ny][nx] = True
                    count += 1

        return count**2

    input = sys.stdin.readline
    N, M = map(int, input().split())
    arr = []
    for i in range(M):
        arr.append(''.join(input()).strip())
    visited = [[False for _ in range(N)] for i in range(M)]
    W = 0
    B = 0
    for i in range(M):
        for j in range(N):
            if visited[i][j]: continue
            result = bfs(i, j, visited)
            if arr[i][j] == "W":
                W += result
            else:
                B += result
    print(f"{W} {B}")
