import sys
from collections import deque, defaultdict


def main():
    input = sys.stdin.readline
    N = int(input())
    indegree = [0] * (N + 1)
    graph = defaultdict(list)
    time = [0] * (N + 1)

    for i in range(1, N + 1):
        tmp = list(map(int, input().split()))
        time[i] = tmp[0]

        for x in tmp[1:-1]:
            graph[x].append(i)
            indegree[i] += 1

    q = deque()
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)

    results = [0] * (N + 1)
    for i in range(1, N + 1):
        results[i] = time[i]

    # 위상 정렬
    while q:
        now = q.popleft()

        for next in graph[now]:
            indegree[next] -= 1
            results[next] = max(results[next], results[now] + time[next])

            if indegree[next] == 0:
                q.append(next)

    for i in range(1, N + 1):
        print(results[i])


if __name__ == '__main__':
    main()
