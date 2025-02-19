import math


def main():
    N = int(input())
    dp = [4] * (N + 1)

    for i in range(1, N + 1):
        if math.sqrt(i).is_integer():
            dp[i] = 1
            continue
        for j in range(1, N):
            if j * j > i:
                break
            dp[i] = min(dp[i], dp[i - j * j] + 1)

    print(dp[N])


if __name__ == '__main__':
    main()
