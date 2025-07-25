import sys

input = sys.stdin.readline
N, K = map(int, input().split())
A = list(map(int, input().split()))
A.sort()

left = 0
right = N - 1
answer = 0
while left < right:
    if A[left] + A[right] > K:
        right -= 1
        continue

    left += 1
    right -= 1
    answer += 1

print(answer)
