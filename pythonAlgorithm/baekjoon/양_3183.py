import sys
from collections import deque

input = sys.stdin.readline

R, C = map(int, input().split())
A = []
for _ in range(R):
    A.append(list(input().strip()))

visited = [[False] * C for _ in range(R)]
D = [(1, 0), (-1, 0), (0, 1), (0, -1)]


def bfs(y, x):
    q = deque()
    q.append((y, x))
    visited[y][x] = True
    sheep = 0
    wolf = 0
    while q:
        y, x = q.popleft()
        if A[y][x] == 'o':
            sheep += 1
        elif A[y][x] == 'v':
            wolf += 1

        for dy, dx in D:
            ny, nx = dy + y, dx + x
            if 0 <= ny < R and 0 <= nx < C and A[ny][nx] != '#' and not visited[ny][nx]:
                visited[ny][nx] = True
                q.append((ny, nx))

    if sheep <= wolf:
        sheep = 0
    else:
        wolf = 0

    return sheep, wolf


sheep_count = 0
wolf_count = 0
for i in range(R):
    for j in range(C):
        if not visited[i][j] and A[i][j] != '#':
            o, v = bfs(i, j)
            sheep_count += o
            wolf_count += v

print(f"{sheep_count} {wolf_count}")
