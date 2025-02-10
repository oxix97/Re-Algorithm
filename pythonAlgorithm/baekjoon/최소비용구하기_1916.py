import sys
from collections import defaultdict
import heapq


def dijkstra(graph, start, arrive, N):
    q = []
    dist = [1e9] * (N + 1)
    dist[start] = 0
    heapq.heappush(q, (0, start))

    while q:
        now_dist, now_node = heapq.heappop(q)
        if now_dist > dist[now_node]: continue

        for next_node, distance in graph[now_node]:
            new_dist = now_dist + distance
            if new_dist < dist[next_node]:
                dist[next_node] = new_dist
                heapq.heappush(q, (new_dist, next_node))

    return dist[arrive]


def main():
    input = sys.stdin.readline
    N = int(input())
    M = int(input())
    graph = defaultdict(list)
    for _ in range(M):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))

    start, arrive = map(int, input().split())

    answer = dijkstra(graph, start, arrive, N)

    print(answer)


if __name__ == '__main__':
    main()
