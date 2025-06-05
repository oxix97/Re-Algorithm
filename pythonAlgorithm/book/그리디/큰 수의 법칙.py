import sys


def main():
    input = sys.stdin.readline
    N, M, K = map(int, input().split())
    A = list(map(int, input().split()))
    A.sort(reverse=True)
    if A[0] == A[1]:
        print(A[0] * M)
        return

    cycle = M // (K + 1)
    other = M % (K + 1)

    answer = cycle * (A[0] * K + A[1])
    answer += A[0] * min(other, K)
    print(answer)


if __name__ == '__main__':
    main()
