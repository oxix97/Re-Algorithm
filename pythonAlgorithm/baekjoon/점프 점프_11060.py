import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
q = deque()
q.append((0,0))
visited = [False] * N
visited[0] =  True
answer = -1
while q:
    now, count = q.popleft()

    if now == N - 1:
        answer = count
        break

    for i in range(1, A[now] + 1):
        if now + i < N and not visited[now + i]:
            visited[now + i] = True
            q.append((now + i, count + 1))

print(answer)
