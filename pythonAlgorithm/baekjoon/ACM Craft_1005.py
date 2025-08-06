import sys
from collections import defaultdict, deque

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    D = [0] + list(map(int, input().split()))
    indegree = [0] * (N + 1)
    graph = defaultdict(list)
    for i in range(K):
        x, y = map(int, input().split())
        graph[x].append(y)
        indegree[y] += 1

    W = int(input())

    q = deque()
    cost = [0] * (N + 1)
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)
            cost[i] = D[i]

    while q:
        now = q.popleft()

        for next in graph[now]:
            indegree[next] -= 1
            cost[next] = max(cost[next], cost[now] + D[next])
            if indegree[next] == 0:
                q.append(next)

    print(cost[W])
