import sys
from collections import defaultdict
from collections import deque


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    total = 1e9
    answer = 0
    for i in range(1, N + 1):
        v = bfs(graph, i)
        if total > v:
            total = v
            answer = i
    print(answer)


def bfs(graph, idx):
    visited = set()
    q = deque()
    q.append((idx, 0))
    visited.add(idx)
    total = 0
    while q:
        now, dist = q.popleft()
        total += dist
        for next in graph[now]:
            if next not in visited:
                q.append((next, dist + 1))
                visited.add(next)
    return total


if __name__ == '__main__':
    main()
