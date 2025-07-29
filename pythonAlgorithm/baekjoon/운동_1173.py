import sys

input = sys.stdin.readline
N, m, M, T, R = map(int, input().split())
if m + T > M:
    print(-1)
else:
    time = 0
    active = 0
    v = m
    while N > 0:
        if v + T <= M:
            v += T
            N -= 1
        else:
            v = max(v - R, m)
        time += 1
    print(time)
