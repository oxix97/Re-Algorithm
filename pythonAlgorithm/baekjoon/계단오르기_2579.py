import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    arr = [0] * 301
    dp = [0] * 301
    for i in range(N):
        arr[i] = int(input())

    dp[0] = arr[0]
    dp[1] = arr[0] + arr[1]
    dp[2] = max(arr[0] + arr[2], arr[1] + arr[2])
    for i in range(3, N):
        a = dp[i - 3] + arr[i - 1] + arr[i]
        b = dp[i - 2] + arr[i]
        dp[i] = max(a, b)
    print(dp[N - 1])


if __name__ == '__main__':
    main()
