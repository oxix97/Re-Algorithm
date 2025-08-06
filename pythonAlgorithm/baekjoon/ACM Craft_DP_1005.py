import sys
from collections import defaultdict
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    D = [0] + list(map(int, input().split()))
    indegree = [0] * (N + 1)
    graph = defaultdict(list)
    for i in range(K):
        x, y = map(int, input().split())
        graph[y].append(x)

    W = int(input())
    dp = [-1] * (N + 1)


    def recursion(n):
        if dp[n] != -1:
            return dp[n]

        max_time = 0
        if n in graph:
            for next in graph[n]:
                max_time = max(max_time, recursion(next))

        dp[n] = max_time + D[n]

        return dp[n]


    print(recursion(W))
