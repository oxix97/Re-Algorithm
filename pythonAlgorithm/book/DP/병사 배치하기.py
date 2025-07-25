import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    dp = [1] * N
    for i in range(1, N):
        for j in range(i):
            if A[j] > A[i]:
                dp[i] = max(dp[i], dp[j] + 1)

    print(N - max(dp))


if __name__ == '__main__':
    main()
