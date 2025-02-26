import sys


def calculate(M, N, x, y):
    if M < N:
        M, N = N, M
        x, y = y, x
    ny = y
    for nx in range(M):
        if ny == x:
            return y + nx * N

        ny += N
        if ny > M:
            ny -= M

    return -1


if __name__ == '__main__':
    input = sys.stdin.readline
    T = int(input())
    for _ in range(T):
        M, N, x, y = map(int, input().split())
        answer = calculate(M, N, x, y)
        print(answer)
