import sys


def main():
    input = sys.stdin.readline
    n = int(input())
    max_length = 1001
    dp = [0] * max_length
    dp[1] = 1
    dp[2] = 2

    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007

    print(dp[n])


if __name__ == "__main__":
    main()
