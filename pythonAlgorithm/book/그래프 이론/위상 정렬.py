import sys
from collections import deque, defaultdict

def main():
    input = sys.stdin.readline
    V, E = map(int, input().split())
    indegree = [0] * (V + 1)
    graph = defaultdict(list)

    for _ in range(E):
        a, b = map(int, input().split())
        graph[a].append(b)
        indegree[b] += 1

    result = []
    q = deque()

    for i in range(1, V + 1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        result.append(now)

        for next in graph[now]:
            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

    for i in result:
        print(i, end=" ")


if __name__ == '__main__':
    main()
