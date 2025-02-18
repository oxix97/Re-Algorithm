import sys
from collections import defaultdict, deque, Counter


def main():
    input = sys.stdin.readline
    N = int(input())
    M = int(input())
    graph = defaultdict(list)
    indegree = [0] * (N + 1)
    needs = [[0] * (N + 1) for _ in range(N + 1)]
    for _ in range(M):
        x, y, k = map(int, input().split())
        graph[y].append((x, k))
        indegree[x] += 1
    q = deque()
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)
            needs[i][i] = 1
    while q:
        now = q.popleft()

        for next, cnt in graph[now]:
            for i in range(1, N + 1):
                needs[next][i] += needs[now][i] * cnt

            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

    for i in range(1, N + 1):
        if needs[N][i] > 0:
            print(f"{i} {needs[N][i]}")


if __name__ == '__main__':
    main()
