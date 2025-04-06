import sys

if __name__ == '__main__':
    input = sys.stdin.readline

    N = int(input())
    L = list(map(int,input().split()))
    J = list(map(int,input().split()))
    dp = [0] * 100

    for i in range(N):
        hp = L[i]
        good = J[i]

        for j in range(99,hp - 1,-1):
            dp[j] = max(dp[j],dp[j - hp] + good)

    print(dp[99])