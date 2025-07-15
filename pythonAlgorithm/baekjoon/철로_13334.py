import sys, heapq

input = sys.stdin.readline
N = int(input())
R = [list(map(int, input().split())) for _ in range(N)]
D = int(input())

lines = []
for i in range(N):
    if R[i][0] > R[i][1]:
        R[i][0], R[i][1] = R[i][1], R[i][0]

    if R[i][1] - R[i][0] > D: continue

    lines.append((R[i][0], R[i][1]))

lines.sort(key=lambda x: (x[1], x[0]))
q = []
answer = 0

for start, end in lines:
    heapq.heappush(q, start)
    while q and q[0] < end - D:
        heapq.heappop(q)
    answer = max(answer, len(q))

print(answer)
