import sys
from collections import deque


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    arr = []
    for _ in range(N):
        row = list(map(int, input().strip()))
        arr.append(row)
    q = deque()
    q.append((0, 0))
    d = [(1, 0), (-1, 0), (0, -1), (0, 1)]
    dist = [[1e9 for _ in range(M)] for _ in range(N)]
    dist[0][0] = 1
    while q:
        y, x = q.popleft()
        for dy, dx in d:
            ny = y + dy
            nx = x + dx
            if is_invalid(ny, nx, N, M): continue
            if arr[ny][nx] == 0: continue
            if dist[ny][nx] > dist[y][x] + 1:
                dist[ny][nx] = dist[y][x] + 1
                q.append((ny, nx))

            if ny == N - 1 and nx == M - 1:
                print(dist[ny][nx])
                return


def is_invalid(y, x, N, M):
    return not (0 <= y < N and 0 <= x < M)


if __name__ == '__main__':
    main()
