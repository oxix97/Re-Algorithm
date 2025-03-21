import sys
from collections import defaultdict, deque

if __name__ == '__main__':

    input = sys.stdin.readline
    N, M = map(int, input().split())
    A = defaultdict(list)
    for i in range(N - 1):
        a, b, dist = map(int, input().split())
        A[a].append((b, dist))
        A[b].append((a, dist))

    for i in range(M):
        a, b = map(int, input().split())
        visited = [False] * (N + 1)
        q = deque()
        q.append((a,0))
        visited[a] = True
        while q:
            now_idx, now_dist = q.popleft()
            if now_idx == b:
                print(now_dist)
                break
            for next_idx, next_dist in A[now_idx]:
                if visited[next_idx]: continue
                visited[next_idx] = True
                q.append((next_idx, next_dist + now_dist))
