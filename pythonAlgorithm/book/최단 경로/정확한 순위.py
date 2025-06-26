import sys


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    graph = [[False for _ in range(N + 1)] for _ in range(N + 1)]

    for _ in range(M):
        a, b = map(int, input().split())
        graph[a][b] = True

    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = True

    answer = 0
    for i in range(1, N + 1):
        count = 1
        for j in range(1, N + 1):
            if i == j: continue
            if graph[i][j] or graph[j][i]:
                count += 1
        if count == N:
            answer += 1

    print(answer)


if __name__ == '__main__':
    main()

