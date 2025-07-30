import sys

input = sys.stdin.readline
N, M = map(int, input().split())
A = []
count = M - 1
for _ in range(M):
    a, b = map(int, input().split())
    if a >= N:
        count -= 1
    else:
        A.append((a, b))

A.sort()
cost = 0
while count > 0:
    a,b = A.pop()
    cost += N - a
    count -= 1

print(cost)