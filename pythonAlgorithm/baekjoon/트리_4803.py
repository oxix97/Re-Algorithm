import sys
from collections import defaultdict, deque

input = sys.stdin.readline

case = 1
while True:
    N, M = map(int, input().split())
    if N == 0 and M == 0: break

    graph = defaultdict(list)
    visit = [False] * (N + 1)
    q = deque()

    for _ in range(M):
        y, x = map(int, input().split())
        graph[y].append(x)
        graph[x].append(y)

    tree_count = 0
    for i in range(1, N + 1):
        if visit[i]:
            continue

        q.append(i)
        visit[i] = True
        node = 1
        edge = 0

        while q:
            u = q.popleft()
            for v in graph[u]:
                edge += 1
                if not visit[v]:
                    q.append(v)
                    visit[v] = True
                    node += 1

        edge /= 2
        if edge == node - 1:
            tree_count += 1

    if tree_count == 0:
        print(f"Case {case}: No trees.")
    elif tree_count == 1:
        print(f"Case {case}: There is one tree.")
    else:
        print(f"Case {case}: A forest of {tree_count} trees.")
    case += 1
