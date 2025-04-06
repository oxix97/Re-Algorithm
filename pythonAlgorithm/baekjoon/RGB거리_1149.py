import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    A = []
    for i in range(N):
        A.append(list(map(int, input().split())))
    dp = [[0 for j in range(3)] for i in range(N)]
    dp[0][0] = A[0][0]
    dp[0][1] = A[0][1]
    dp[0][2] = A[0][2]
    for i in range(1, N):
        for j in range(3):
            idx = [0, 1, 2]
            idx.remove(j)
            dp[i][j] = min(dp[i - 1][idx.pop()], dp[i - 1][idx.pop()]) + A[i][j]
    min_value = min(dp[N - 1])
    print(min_value)
