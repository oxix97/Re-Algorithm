import sys,heapq

input = sys.stdin.readline
n,m = map(int,input().split())
A = list(map(int,input().split()))
q =  []
for a in A:
    heapq.heappush(q,a)

for _ in range(m):
    x = heapq.heappop(q)
    y = heapq.heappop(q)
    z = x + y
    heapq.heappush(q,z)
    heapq.heappush(q,z)

print(sum(q))


