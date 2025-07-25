import sys
from collections import defaultdict

input = sys.stdin.readline
T = int(input())


def solution():
    D, N = map(int, input().split())
    nums = list(map(int, input().split()))
    remainder = [0] * D
    remainder[0] = 1
    snum = 0
    answer = 0

    for num in nums:
        snum = (snum + num) % D
        answer += remainder[snum]
        remainder[snum] += 1

    print(answer)


for _ in range(T):
    solution()
