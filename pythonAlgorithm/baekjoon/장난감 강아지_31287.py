import sys


def main():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    S = input().strip()
    T = S * min(N // 2, K)
    d = {'U': (-1, 0), 'D': (1, 0), 'L': (0, -1), 'R': (0, 1)}
    y, x = 0, 0
    answer = 'NO'
    for t in T:
        dy, dx = d[t]
        ny, nx = y + dy, x + dx
        if ny == 0 and nx == 0:
            answer = 'YES'
            break
        y, x = ny, nx

    print(answer)


if __name__ == '__main__':
    main()
