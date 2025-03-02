import sys
from collections import deque

if __name__ == '__main__':
    input = sys.stdin.readline
    N, M = map(int, input().split())
    arr = []
    for i in range(N):
        arr.append(list(map(int, input().split())))

    # 상,하,좌,우,좌상,우상,좌하,우하
    dy = [-1, 1, 0, 0, -1, -1, 1, 1]
    dx = [0, 0, -1, 1, -1, 1, -1, 1]

    q = deque()
    dist = [[-1 for _ in range(M)] for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                q.append((i, j))
                dist[i][j] = 0

    while q:
        y, x = q.popleft()

        for i in range(8):
            ny = y + dy[i]
            nx = x + dx[i]

            if ny < 0 or ny >= N or nx < 0 or nx >= M or dist[ny][nx] != -1:
                continue

            dist[ny][nx] = dist[y][x] + 1
            q.append((ny, nx))

    # 안전 거리의 최댓값 찾기
    max_safe_distance = 0
    for i in range(N):
        for j in range(M):
            max_safe_distance = max(max_safe_distance, dist[i][j])

    print(max_safe_distance)
