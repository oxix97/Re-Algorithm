import sys
from collections import defaultdict
import heapq


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    graph = defaultdict(list)
    arr = [0] * (N + 1)
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        arr[b] += 1

    q = []
    answer = []
    for i in range(1, N + 1):
        if arr[i] == 0:
            heapq.heappush(q, i)

    while q:
        v = heapq.heappop(q)
        answer.append(v)
        for idx in graph[v]:
            arr[idx] -= 1
            if arr[idx] == 0:
                heapq.heappush(q, idx)

    print(*answer)


if __name__ == '__main__':
    main()
