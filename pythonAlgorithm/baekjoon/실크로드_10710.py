import sys

input = sys.stdin.readline
N, M = map(int, input().split())
D = [0] * 1001
for i in range(1, N + 1):
    D[i] = int(input())
C = [0] * 1001
for i in range(1, M + 1):
    C[i] = int(input())

dp = [[1e9] * 1001 for _ in range(1001)]
for i in range(1, M + 1):
    dp[1][i] = D[1] * C[i]

for i in range(2, N + 1):  # 위치
    prev = 1e9
    for j in range(i, M + 1):  # 일자
        prev = min(prev, dp[i - 1][j - 1])
        dp[i][j] = prev + D[i] * C[j]

print(min(dp[N]))
