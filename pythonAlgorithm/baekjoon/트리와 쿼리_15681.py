import sys
from collections import defaultdict, deque

sys.setrecursionlimit(int(1e9))
input = sys.stdin.readline
N, R, Q = map(int, input().split())
graph = defaultdict(list)
tree = defaultdict(list)
parent = [0] * (N + 1)


def bfs(n):
    q = deque()
    q.append(n)
    visited = [False] * (N + 1)
    visited[n] = True

    while q:
        now = q.popleft()

        for next in graph[now]:
            if not visited[next]:
                visited[next] = True
                q.append(next)
                tree[now].append(next)


for _ in range(N - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 트리를 만든다.
bfs(R)
size = [0] * (N + 1)
visited = [False] * (N + 1)


def dfs(now):
    visited[now] = True
    size[now] = 1

    for next in tree[now]:
        if not visited[next]:
            dfs(next)
            size[now] += size[next]

# 서브트리 정점 계산
dfs(R)

for _ in range(Q):
    q = int(input())
    print(size[q])
