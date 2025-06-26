import heapq
import sys
from collections import defaultdict


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    INF = int(1e9)
    graph = defaultdict(list)
    distance = [INF for _ in range(N + 1)]
    distance[1] = 0

    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    q = []
    heapq.heappush(q, (0, 1))
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]: continue
        for next in graph[now]:
            if dist + 1 < distance[next]:
                distance[next] = dist + 1
                heapq.heappush(q, (distance[next], next))

    max_distance = 0
    first_pos = 0
    max_count = 0

    for i in range(1, N + 1):
        if distance[i] > max_distance:
            max_distance = distance[i]
            first_pos = i
            max_count = 1
        elif distance[i] == max_distance:
            max_count += 1

    print(f"{first_pos} {max_distance} {max_count}")


if __name__ == '__main__':
    main()