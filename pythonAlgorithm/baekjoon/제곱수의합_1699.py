
def main():
    N = int(input())
    dp = [0] + [1e9] * N
    for i in range(1,N + 1):
        j = 1
        while j * j <= i:
            dp[i] = min(dp[i], dp[i - j*j] + 1)
            j += 1
    print(dp[N])


if __name__ == '__main__':
    main()
