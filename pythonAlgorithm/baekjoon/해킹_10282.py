import sys
from collections import defaultdict, Counter
import heapq


def dijkstra(graph, start, end):
    q = []
    INF = int(1e9)
    dist = [INF] * (end + 1)
    dist[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        d, n = heapq.heappop(q)
        if d > dist[n]: continue

        for next, nd in graph[n]:
            new_dist = d + nd
            if new_dist < dist[next]:
                dist[next] = new_dist
                heapq.heappush(q, (new_dist, next))

    c = Counter(dist)
    del c[INF]
    count = c.total()
    total = max(c)
    return count, total


def main():
    input = sys.stdin.readline
    T = int(input())
    for _ in range(T):
        N, D, C = map(int, input().split())
        graph = defaultdict(list)
        for _ in range(D):
            a, b, s = map(int, input().split())
            graph[b].append((a, s))
        count, time = dijkstra(graph, C, N)
        print(f"{count} {time}")


if __name__ == '__main__':
    main()
