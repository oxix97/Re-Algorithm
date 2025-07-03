import sys, heapq
from collections import defaultdict


def main():
    def dfs(u):
        times = []
        for v in graph[u]:
            dfs(v)
            times.append(D[v])
        times.sort(reverse=True)

        D[u] = 0
        for i in range(len(times)):
            D[u] = max(D[u], i + 1 + times[i])

    input = sys.stdin.readline
    N = int(input())
    graph = defaultdict(list)
    A = list(map(int, input().split()))
    D = [0] * N
    for i in range(1, N):
        graph[A[i]].append(i)

    dfs(0)
    print(D[0])


if __name__ == '__main__':
    main()
