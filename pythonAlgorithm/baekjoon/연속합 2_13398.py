import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
D = [0] * N
E = [0] * N
D[0] = A[0]
E[0] = A[0]
for i in range(1, N):
    D[i] = max(D[i - 1] + A[i], A[i])
    E[i] = max(E[i - 1] + A[i], D[i - 1])

answer = max(max(D),max(E))
print(answer)

