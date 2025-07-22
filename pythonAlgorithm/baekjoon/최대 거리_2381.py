import sys

input = sys.stdin.readline

N = int(input())
U = []
V = []
for _ in range(N):
    x, y = map(int, input().split())
    U.append(x + y)
    V.append(x - y)

answer = max(max(U) - min(U), max(V) - min(V))
print(answer)

