import sys
from collections import defaultdict


def dfs(idx):
    for n in A[idx]:
        if n == 1 or visited[n]:
            continue
        visited[n] = True
        parents[n] = idx
        dfs(n)

sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())
A = defaultdict(list)
visited = [False for _ in range(N + 1)]
parents = [0 for _ in range(N + 1)]

if __name__ == '__main__':
    for _ in range(N - 1):
        s, e = map(int, input().split())
        A[s].append(e)
        A[e].append(s)
    dfs(1)
    for n in parents[2:]:
        print(n)
