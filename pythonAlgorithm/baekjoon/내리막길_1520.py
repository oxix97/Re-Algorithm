import sys
from collections import deque

dy = [0, 0, 1]
dx = [-1, 1, 0]


def main():
    input = sys.stdin.readline
    M, N = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(M)]
    dp = [[0 for _ in range(N)] for _ in range(M)]
    dp[0][0] = 1
    dfs(0, 0, M, N, arr, dp)
    print(dp)


def dfs(y, x, m, n, arr, dp):
    v = []
    for i in range(3):
        ny = y + dy[i]
        nx = x + dx[i]
        if range_check(ny, nx, m, n) and value_check(arr, ny, nx, y, x):
            v.append((ny, nx))

    for i in range(len(v)):
        idx = i + 1

    for ny, nx in v:
        dfs(ny, nx, m, n, arr, dp)


def value_check(arr, ny, nx, y, x):
    return arr[ny][nx] < arr[y][x]


def range_check(ny, nx, y, x):
    return 0 <= ny < y and 0 <= nx < x


if __name__ == '__main__':
    main()
