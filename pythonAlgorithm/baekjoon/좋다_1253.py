import sys


def find_good(good):
    left = 0
    right = N - 1
    while left < right:
        snum = A[left] + A[right]
        if snum == good:
            if i == left:
                left += 1
                continue
            if i == right:
                right -= 1
                continue
            return 1
        elif snum < good:
            left += 1
        else:
            right -= 1

    return 0


input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
A.sort()
answer = 0

for i in range(N):
    answer += find_good(A[i])

print(answer)
