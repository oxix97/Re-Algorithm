import sys
from collections import defaultdict
import heapq


def main():
    input = sys.stdin.readline
    N, D = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(N):
        start, arrive, v = map(int, input().split())
        if arrive > D or arrive - start <= v: continue
        graph[start].append((arrive, v))

    for i in range(D):
        graph[i].append((i + 1, 1))
    answer = dijkstra(graph, D)
    print(answer)


def dijkstra(graph, D):
    q = []
    dist = [1e9] * (D + 1)
    dist[0] = 0
    heapq.heappush(q, (0, 0))
    while q:
        now_dist, now_node = heapq.heappop(q)
        if now_dist > dist[now_node]: continue

        for next_node, weight in graph[now_node]:
            new_dist = weight + now_dist
            if new_dist < dist[next_node]:
                dist[next_node] = new_dist
                heapq.heappush(q, (new_dist, next_node))

    return dist[D]


if __name__ == '__main__':
    main()
