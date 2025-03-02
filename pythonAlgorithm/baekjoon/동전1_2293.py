import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N, K = map(int, input().split())
    arr = []
    dp = [0] * (K + 1)
    dp[0] = 1
    for i in range(N):
        arr.append(int(input()))

    for coin in arr:
        for i in range(coin, K + 1):
            dp[i] += dp[i - coin]

    print(dp[K])
