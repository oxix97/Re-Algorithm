import sys
from collections import defaultdict, deque

def main():
    input = sys.stdin.readline
    INF = 300_001
    N, M, K, X = map(int, input().split())
    graph = defaultdict(list)
    q = deque()
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
    dist = [INF] * (N + 1)
    dist[X] = 0
    q.append(X)

    while q:
        now = q.popleft()
        for next in graph[now]:
            if dist[now] + 1 < dist[next]:
                dist[next] = dist[now] + 1
                q.append(next)

    find = False
    for i in range(1,N + 1):
        if dist[i] == K:
            find = True
            print(i)

    if not find:
        print(-1)

if __name__ == '__main__':
    main()
