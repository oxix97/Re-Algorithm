import sys
from collections import defaultdict
import heapq


def main():
    input = sys.stdin.readline
    N, M, X = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(M):
        start, end, time = map(int, input().split())
        graph[start].append((end, time))

    # home -> X
    current_dist = [0] * (N + 1)
    for i in range(1, N + 1):
        current_dist[i] = dijkstra(graph, i, X, N)

    # X -> home
    reverse_dist = [0] * (N + 1)
    for i in range(1, N + 1):
        reverse_dist[i] = dijkstra(graph, X, i, N)

    # sum
    max_time = 0
    for current, reverse in zip(current_dist, reverse_dist):
        max_time = max(max_time, current + reverse)

    print(max_time)


def dijkstra(graph, start, end, n):
    dist = [1e9] * (n + 1)
    dist[start] = 0
    q = []
    heapq.heappush(q, (0, start))
    while q:
        now_dist, now_node = heapq.heappop(q)
        if now_dist > dist[now_node]: continue
        for next_node, weight in graph[now_node]:
            new_dist = now_dist + weight
            if new_dist < dist[next_node]:
                dist[next_node] = new_dist
                heapq.heappush(q, (new_dist, next_node))

    return dist[end]


if __name__ == '__main__':
    main()
