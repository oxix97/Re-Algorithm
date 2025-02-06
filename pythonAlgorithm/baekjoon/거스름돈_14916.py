import sys


def main():
    input = sys.stdin.readline
    money = int(input())
    dp = [1e9] * 100_001
    dp[2] = 1
    dp[4] = 2
    dp[5] = 1
    for i in range(6, 100_001):
        dp[i] = min(dp[i - 2] + 1, dp[i])
        dp[i] = min(dp[i - 5] + 1, dp[i])

    if dp[money] == 1e9:
        print(-1)
    else:
        print(dp[money])


if __name__ == '__main__':
    main()
