import sys

input = sys.stdin.readline
N = int(input())
C = [int(input()) for _ in range(N)]
C.sort()
cost = 0
while len(C) > 2:
    a = C.pop()
    b = C.pop()
    C.pop()
    cost += a + b

while C:
    cost += C.pop()

print(cost)
