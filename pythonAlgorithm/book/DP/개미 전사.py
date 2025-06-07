import sys

def main():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int,input().split()))
    dp = [0] * 100
    dp[0] = A[0]
    dp[1] = max(A[0],A[1])

    for i in range(2,N):
        dp[i] = max(dp[i - 1], dp[i - 2] + A[i])

    print(dp[N - 1])

if __name__ == '__main__':
    main()