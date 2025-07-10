import sys
from itertools import combinations

input = sys.stdin.readline
N = int(input())
nums = list(map(int, input().split()))
nums.sort()
answer = 0
for i in range(N):
    left, right = 0, N - 1
    target = nums[i]
    while left < right:
        snum = nums[left] + nums[right]
        if snum == target:
            if left == i:
                left += 1
                continue
            if right == i:
                right -= 1
                continue
            answer += 1
            break
        elif snum < target:
            left += 1
        else:
            right -= 1
print(answer)