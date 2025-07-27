import sys

# 구현
input = sys.stdin.readline
N = int(input())
W = list(map(int, input().split()))


def recursion(weights):
    if len(weights) == 2:
        return 0

    max_energy = 0
    for x in range(1, len(weights) - 1):
        e = weights[x - 1] * weights[x + 1]
        remain = weights[:x] + weights[x + 1:]
        total_energy = e + recursion(remain)
        max_energy = max(max_energy, total_energy)

    return max_energy

answer = recursion(W)
print(answer)
