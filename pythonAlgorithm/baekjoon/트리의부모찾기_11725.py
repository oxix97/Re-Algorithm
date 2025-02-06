import sys
from collections import defaultdict

def main():
    sys.setrecursionlimit(10 ** 6)
    input = sys.stdin.readline
    N = int(input())
    graph = defaultdict(list)
    for _ in range(N -1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    parent = [0] * (N + 1)
    parent[1] = -1
    dfs(graph, 1, parent)
    for i in range(2,N + 1):
        print(parent[i])

def dfs(graph, now, parent):
    for next in graph[now]:
        if parent[next] != 0: continue
        parent[next] = now
        dfs(graph, next, parent)


if __name__ == '__main__':
    main()
