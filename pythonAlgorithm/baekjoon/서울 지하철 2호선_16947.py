import sys
from collections import defaultdict, deque

input = sys.stdin.readline

N = int(input())
A = defaultdict(list)

for _ in range(N):
    a, b = map(int, input().split())
    A[a].append(b)
    A[b].append(a)

graph = A.copy()
q = deque()
R = [True] * (N + 1)
for i in range(1, N + 1):
    if len(A[i]) == 1:
        q.append(i)
        R[i] = False

while q:
    now = q.popleft()
    for next in A[now]:
        if now in A[next]:
            A[next].remove(now)
        if len(A[next]) == 1:
            q.append(next)
            R[next] = False


def bfs(n):
    q = deque()
    q.append((n, 0))
    visit = [False] * (N + 1)
    visit[n] = True

    while q:
        now, dist = q.popleft()
        if R[now]:
            return dist
        for next in graph[now]:
            if not visit[next]:
                q.append((next, dist + 1))

    return -1


dist = [0] * (N + 1)
for i in range(1, N + 1):
    if R[i]: continue
    dist[i] = bfs(i)

print(*dist[1:])
