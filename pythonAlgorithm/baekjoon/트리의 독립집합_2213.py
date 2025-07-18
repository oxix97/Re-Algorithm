import sys
from collections import defaultdict

# 풀이
def dfs(u):
    visited[u] = True
    D[u] = W[u - 1]
    Dn[u].append(u)
    for v in graph[u]:
        if not visited[v]:
            dfs(v)
            D[u] += E[v]
            Dn[u].extend(En[v])

            if D[v] < E[v]:
                E[u] += E[v]
                En[u].extend(En[v])
            else:
                E[u] += D[v]
                En[u].extend(Dn[v])


# 입력
input = sys.stdin.readline
N = int(input())
W = list(map(int, input().split()))
graph = defaultdict(list)
for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for _ in range(N + 1)]
D = [0] * (N + 1)
E = [0] * (N + 1)
Dn = [[] for _ in range(N + 1)]
En = [[] for _ in range(N + 1)]

# 출력
dfs(1)
if D[1] < E[1]:
    print(E[1])
    En[1].sort()
    print(*En[1])
else:
    print(D[1])
    Dn[1].sort()
    print(*Dn[1])
