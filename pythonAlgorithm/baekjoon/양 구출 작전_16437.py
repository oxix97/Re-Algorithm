import sys
from collections import defaultdict

sys.setrecursionlimit(123457)


def recursion(u):
    result = A[u]

    for v in graph[u]:
        result += recursion(v)

    return max(result, 0)


input = sys.stdin.readline
N = int(input())
graph = defaultdict(list)
A = [0] * (N + 1)
for i in range(2, N + 1):
    animal, count, piv = input().split()
    count, piv = int(count), int(piv)
    if animal == 'W':
        count = -count
    A[i] = count
    graph[piv].append(i)

answer = recursion(1)
print(answer)
