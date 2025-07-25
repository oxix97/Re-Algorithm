import sys
from collections import defaultdict, deque

# 입력 처리
input = sys.stdin.readline
N = int(input())
M = int(input())

# 초기화
A = defaultdict(list)
indegree = [0] * (N + 1)
result = [defaultdict(int) for _ in range(N + 1)]

# 진입 차수 계산
for _ in range(M):
    x, y, k = map(int, input().split())
    A[y].append((x, k))
    indegree[x] += 1

q = deque()
for i in range(1, N + 1):
    if indegree[i] == 0:
        q.append(i)
        result[i][i] = 1

# 위상 정렬 실행
while q:
    now = q.popleft()

    for next, count in A[now]:
        for part, amount in result[now].items():
            result[next][part] += amount * count

        indegree[next] -= 1

        if indegree[next] == 0:
            q.append(next)

for i in sorted(result[N].keys()):
    print(f"{i} {result[N][i]}")
