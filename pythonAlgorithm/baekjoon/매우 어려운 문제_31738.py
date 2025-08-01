import sys

input = sys.stdin.readline
N, M = map(int, input().split())

if N >= M:
    print(0)
else:
    n = 1
    for i in range(1, N + 1):
        n *= i
        n %= M
    print(n)
