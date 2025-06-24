import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    A = [(0, 0)]
    dp = [0 for _ in range(N + 2)]

    for i in range(1, N + 1):
        T, P = map(int, input().split())
        A.append((T, P))
    for i in range(1, N + 1):
        t, p = A[i]
        while i + t <= N + 1:
            if dp[i + t] < dp[i] + p:
                dp[i + t] = dp[i] + p
            t += 1

    print(dp[N + 1])


if __name__ == '__main__':
    main()
