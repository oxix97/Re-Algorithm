def main():
    N = input().strip()
    n = len(N)
    dp = [0 for _ in range(n + 1)]
    dp[0] = 1
    dp[1] = 1

    for i in range(2, n + 1):
        if int(N[i - 1]) > 0:
            dp[i] = dp[i - 1]
        if 10 <= int(N[i - 2:i]) <= 34:
            dp[i] += dp[i - 2]

    print(dp[n])


if __name__ == '__main__':
    main()
