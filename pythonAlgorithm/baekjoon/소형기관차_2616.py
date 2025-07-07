import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    C = int(input())
    psum = [0] * N
    psum[0] = A[0]
    for i in range(1, N):
        psum[i] = psum[i - 1] + A[i]

    dp = [[0] * 4 for _ in range(N)]
    for i in range(1, 4):
        dp[0][i] = A[0]

    for i in range(1, N):
        for j in range(1, 4):
            dp[i][j] = dp[i - 1][j]

            if i <= C - 1:
                dp[i][j] = max(dp[i][j], psum[i])
            else:
                cost = psum[i] - psum[i - C]
                dp[i][j] = max(dp[i][j], cost + dp[i - C][j - 1])

    print(dp[N - 1][3])

if __name__ == '__main__':
    main()
