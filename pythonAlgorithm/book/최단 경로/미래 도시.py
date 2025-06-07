import sys


def main():
    input = sys.stdin.readline
    INF = 1e9
    N, M = map(int, input().split())
    graph = [[INF] * (N + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        graph[i][i] = 0

    for _ in range(M):
        i, j = map(int, input().split())
        graph[i][j] = 1
        graph[j][i] = 1

    X, K = map(int, input().split())

    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    distance = graph[1][K] + graph[K][X]
    if distance >= INF:
        print(-1)
    else:
        print(distance)


if __name__ == '__main__':
    main()
