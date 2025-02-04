import sys
from collections import defaultdict

def main():
    sys.setrecursionlimit(10 ** 6)
    input = sys.stdin.readline
    N, M = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    visited = set()
    answer = 0

    for i in range(1, N + 1):
        if i not in visited:
            dfs(graph, i, visited)
            answer += 1

    print(answer)

def dfs(graph, idx, visited):
    if idx in visited:
        return
    visited.add(idx)
    for i in graph[idx]:
        if i not in visited:
            dfs(graph, i, visited)


if __name__ == '__main__':
    main()
