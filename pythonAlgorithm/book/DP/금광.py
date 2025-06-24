import sys


def solution(N, M, arr):
    A = [arr[i:i + M] for i in range(0, len(arr), M)]
    dp = [[0 for _ in range(M)] for _ in range(N)]
    for i in range(N):
        dp[i][0] = A[i][0]
    for x in range(1,M):
        for y in range(N):
            left_up = dp[y - 1][x - 1] if y > 0 else 0
            left = dp[y][x - 1]
            left_down = dp[y + 1][x - 1] if y < N - 1 else 0
            dp[y][x] = A[y][x] + max(left_up,left,left_down)

    result = 0
    for i in range(N):
        result = max(result, dp[i][M - 1])
    return result


if __name__ == '__main__':
    input = sys.stdin.readline
    T = int(input())
    answer = []
    for _ in range(T):
        N, M = map(int, input().split())
        arr = list(map(int, input().split()))
        answer.append(solution(N, M, arr))

    for ans in answer:
        print(ans)

# 2
# 3 4
# 1 3 3 2 2 1 4 1 0 6 4 7
# 4 4
# 1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
