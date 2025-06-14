def main():
    N = int(input())
    dp = [0] * 30001
    for i in range(2, N + 1):
        dp[i] = dp[i - 1] + 1
        if i % 2 == 0:
            dp[i] = min(dp[i], dp[i // 2] + 1)
        if i % 3 == 0:
            dp[i] = min(dp[i], dp[i // 3] + 1)
        if i % 5 == 0:
            dp[i] = min(dp[i], dp[i // 5] + 1)

    print(dp[N])


if __name__ == '__main__':
    main()
