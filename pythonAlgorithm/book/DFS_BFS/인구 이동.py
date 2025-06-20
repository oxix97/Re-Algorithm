import sys
from collections import deque


def main():
    def bfs(y, x):
        if visited[y][x]: return 0

        q = deque([(y,x)])
        union = [(y, x)]
        visited[y][x] = True
        total = A[y][x]

        while q:
            y, x = q.popleft()
            for dy, dx in D:
                ny, nx = y + dy, x + dx
                if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx] and L <= abs(A[y][x] - A[ny][nx]) <= R:
                    q.append((ny, nx))
                    visited[ny][nx] = True
                    union.append((ny, nx))
                    total += A[ny][nx]
        if len(union) == 1:
            return 0

        union_value = total // len(union)
        for y, x in union:
            A[y][x] = union_value
        return 1

    input = sys.stdin.readline
    N, L, R = map(int, input().split())
    A = [list(map(int, input().split())) for _ in range(N)]
    D = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    day = 0
    while True:
        visited = [[False for _ in range(N)] for _ in range(N)]
        move_count = sum(bfs(i,j) for i in range(N) for j in range(N))
        if move_count == 0:
            break
        day += 1
    print(day)


if __name__ == '__main__':
    main()
