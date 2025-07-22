N = int(input())
dp = [False] * 1001

dp[1] = True
dp[3] = True
dp[4] = True

for i in range(5, 1001):
    if not dp[i - 1] or not dp[i - 3] or not dp[i - 4]:
        dp[i] = True

answer = "SK" if dp[N] else "CY"
print(answer)
