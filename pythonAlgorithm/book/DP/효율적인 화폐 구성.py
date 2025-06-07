import sys

def main():
    input = sys.stdin.readline
    N,M = map(int,input().split())
    dp = [10_001] * (M + 1)
    dp[0] = 0
    coins = [int(input()) for _ in range(N)]

    for coin in coins:
        for i in range(coin, M + 1):
            if dp[i - coin] != 10_001:
                dp[i] = min(dp[i], dp[i - coin] + 1)

    if dp[M] == 10_001:
        print(-1)
    else:
        print(dp[M])

if __name__ == '__main__':
    main()