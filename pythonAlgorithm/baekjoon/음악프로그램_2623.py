import sys
from collections import defaultdict, deque


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    graph = defaultdict(list)
    arr = [0] * (N + 1)
    for _ in range(M):
        tmp = list(map(int, input().split()))
        for i in range(1, len(tmp) - 1):
            graph[tmp[i]].append(tmp[i + 1])
            arr[tmp[i + 1]] += 1

    answer = []
    q = deque()
    for i in range(1, N + 1):
        if arr[i] == 0:
            q.append(i)

    while q:
        v = q.popleft()
        answer.append(v)

        for i in graph[v]:
            arr[i] -= 1
            if arr[i] == 0:
                q.append(i)

    if len(answer) != N:
        print(0)
        return

    for ans in answer:
        print(ans)


if __name__ == '__main__':
    main()
