import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline
N, M = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
cells = [(i, j) for i in range(N) for j in range(M) if graph[i][j] == 0]
dy = [1, -1, 0, 0]
dx = [0, 0, -1, 1]
max_safe = 0

def spread_virus(temp_graph):
    q = deque()
    for i in range(N):
        for j in range(M):
            if temp_graph[i][j] == 2:  # 바이러스 위치를 큐에 추가
                q.append((i, j))

    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < N and 0 <= nx < M and temp_graph[ny][nx] == 0:
                temp_graph[ny][nx] = 2
                q.append((ny, nx))


def count_safe_area(temp_graph):
    return sum(row.count(0) for row in temp_graph)


for comb in combinations(cells, 3):
    temp_graph = [row[:] for row in graph]

    for y, x in comb:
        temp_graph[y][x] = 1

    spread_virus(temp_graph)

    max_safe = max(max_safe, count_safe_area(temp_graph))

print(max_safe)
