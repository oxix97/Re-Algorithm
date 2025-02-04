import sys
from collections import defaultdict
from collections import deque


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
            answer += 1
            bfs(graph, i, visited)

    print(answer)


def bfs(graph, idx, visited):
    q = deque([idx])
    visited.add(idx)

    while q:
        v = q.popleft()
        for i in graph[v]:
            if i not in visited:
                q.append(i)
                visited.add(i)


if __name__ == '__main__':
    main()
