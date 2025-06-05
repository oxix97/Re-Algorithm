import sys


def main():
    def dfs(x, y):
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and A[nx][ny] == '0' and not visited[nx][ny]:
                dfs(nx, ny)

    input = sys.stdin.readline
    N, M = map(int, input().split())
    A = [list(input().strip()) for _ in range(N)]

    visited = [[False for _ in range(M)] for _ in range(N)]
    answer = 0
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(N):
        for j in range(M):
            if A[i][j] == '0' and not visited[i][j]:
                answer += 1
                dfs(i, j)

    print(answer)


if __name__ == '__main__':
    main()
