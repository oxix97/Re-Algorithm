import sys

input = sys.stdin.readline
T = int(input())
dp = [0 for _ in range(10001)]
dp[0] = 1

for i in range(1, 4):
    for j in range(i, 10001):
        dp[j] += dp[j - i]

for _ in range(T):
    n = int(input())
    print(dp[n])
