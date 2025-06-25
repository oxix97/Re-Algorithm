import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    M = int(input())
    graph = [[0 if i == j else 1e9 for j in range(N + 1)] for i in range(N + 1)]

    for _ in range(M):
        a, b, c = map(int, input().split())
        graph[a][b] = c

    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                cost = graph[i][k] + graph[k][j]
                if graph[i][j] > cost:
                    graph[i][j] = cost

    for i in range(1, N + 1):
        print(*graph[i][1:])


if __name__ == '__main__':
    main()
