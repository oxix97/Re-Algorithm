import sys
from collections import defaultdict

sys.setrecursionlimit(100000)
def main():
    def dfs(now):
        visited[now] = True
        for cost, next in graph[now]:
            if not visited[next]:
                dist[next] = dist[now] + cost
                dfs(next)

    input = sys.stdin.readline
    N = int(input())
    graph = defaultdict(list)
    visited = [False] * (N + 1)
    dist = [0] * (N + 1)

    for _ in range(N - 1):
        a, b, c = map(int, input().split())
        graph[a].append((c, b))
        graph[b].append((c, a))

    dfs(1)
    max_dist = 0
    to = 0
    for i in range(1, N + 1):
        if max_dist < dist[i]:
            max_dist = dist[i]
            to = i

    visited = [False] * (N + 1)
    dist = [0] * (N + 1)
    dfs(to)
    for i in range(1, N + 1):
        if max_dist < dist[i]:
            max_dist = dist[i]

    print(max_dist)


if __name__ == '__main__':
    main()
