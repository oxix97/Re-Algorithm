A, K = map(int, input().split())

dp = [1_000_001] * 1_000_001
dp[A] = 0

for n in range(A + 1, 1_000_001):
    dp[n] = dp[n - 1] + 1
    if n >= A * 2 and n % 2 == 0:
        dp[n] = dp[n // 2] + 1

print(dp[K])