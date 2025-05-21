import sys


def main():
    input = sys.stdin.readline
    N, M, Q = map(int, input().split())
    A = [[0 for _ in range(M + 1)] for _ in range(N + 1)]
    row = [0] * (N + 1)
    col = [0] * (M + 1)

    for _ in range(Q):
        n, i, j = map(int, input().split())
        if n == 1:
            row[i] += j
        if n == 2:
            col[i] += j

    for i in range(1, N + 1):
         for j in range(1,M + 1):
             A[i][j] += row[i]
    for j in range(1, M + 1):
        for i in range(1, N + 1):
            A[i][j] += col[j]

    for i in range(1, N + 1):
        print(*A[i][1:])


if __name__ == '__main__':
    main()
