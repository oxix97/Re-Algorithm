import sys
from collections import deque
from itertools import combinations


def main():
    def spread_virus():
        T = [row[:] for row in A]
        q = deque(virus_area)
        while q:
            y, x = q.popleft()
            for dy, dx in D:
                ny, nx = y + dy, x + dx
                if 0 <= ny < N and 0 <= nx < M and T[ny][nx] == 0:
                    T[ny][nx] = 2
                    q.append((ny, nx))

        return sum(row.count(0) for row in T)

    input = sys.stdin.readline
    N, M = map(int, input().split())
    A = [list(map(int, input().split())) for _ in range(N)]
    D = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    empty_area = []
    virus_area = []
    answer = 0
    for i in range(N):
        for j in range(M):
            if A[i][j] == 2:
                virus_area.append((i, j))
            if A[i][j] == 0:
                empty_area.append((i, j))

    # 1. 벽세우기
    for walls in combinations(empty_area, 3):
        for y, x in walls:
            A[y][x] = 1

        safe_area = spread_virus()
        answer = max(answer, safe_area)

        for y, x in walls:
            A[y][x] = 0

    print(answer)


if __name__ == '__main__':
    main()
