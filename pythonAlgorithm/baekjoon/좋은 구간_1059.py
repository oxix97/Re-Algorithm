import sys

input = sys.stdin.readline
L = int(input())
S = list(map(int, input().split()))
N = int(input())

if N in S:
    print(0)
else:
    answer = 0
    S.append(0)
    S.sort()
    for i in range(L):
        if S[i] < N < S[i + 1]:
            answer = (N - S[i]) * (S[i + 1] - N) - 1
            break
    print(answer)
