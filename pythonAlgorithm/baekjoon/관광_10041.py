import sys

input = sys.stdin.readline

W, H, N = map(int, input().split())

x, y = map(int, input().split())
answer = 0
for _ in range(N - 1):
    nx, ny = map(int, input().split())
    dx, dy = nx - x, ny - y

    if dx * dy >= 0:
        answer += max(abs(dx), abs(dy))
    else:
        answer += abs(dx) + abs(dy)

    x, y = nx, ny

print(answer)
