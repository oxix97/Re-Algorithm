import sys


def main():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    A = list(map(int, input().split()))
    A.sort()
    B = [map(int, input().split()) for _ in range(K)]
    for L, R, X in B:
        for i in range(L - 1, R):
            A[i] += X
        A.sort()
    print(*A)


if __name__ == '__main__':
    main()
