import sys

input = sys.stdin.readline
N = int(input())
A = [list(map(int, input().split())) for _ in range(N)]
A.sort(key=lambda x: x[1], reverse=True)
S = [False] * 1001

answer = 0
for i in range(N):
    for j in range(A[i][0], 0, -1):
        if not S[j]:
            S[j] = True
            answer += A[i][1]
            break

print(answer)
