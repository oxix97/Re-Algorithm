import sys
from collections import defaultdict
import heapq

INF = int(1e9)


def main():
    input = sys.stdin.readline
    N, E = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(E):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))
        graph[b].append((a, c))
    v1, v2 = map(int, input().split())

    dist_1 = dijkstra(graph, 1, N)
    dist_v1 = dijkstra(graph, v1, N)
    dist_v2 = dijkstra(graph, v2, N)

    path1 = dist_1[v1] + dist_v1[v2] + dist_v2[N]
    path2 = dist_1[v2] + dist_v2[v1] + dist_v1[N]

    if dist_1[v1] == INF or dist_v1[v2] == INF or dist_v2[N] == INF:
        path1 = INF
    if dist_1[v2] == INF or dist_v2[v1] == INF or dist_v1[N] == INF:
        path2 = INF

    answer = min(path1, path2)
    if answer == INF:
        answer = -1
    print(answer)


def dijkstra(graph, start, end):
    q = []
    dist = [INF] * (end + 1)
    dist[start] = 0
    heapq.heappush(q, (0, start))
    while q:
        now_dist, now_node = heapq.heappop(q)
        if now_dist > dist[now_node]: continue

        for next_node, weight in graph[now_node]:
            new_dist = now_dist + weight
            if new_dist < dist[next_node]:
                dist[next_node] = new_dist
                heapq.heappush(q, (new_dist, next_node))
    return dist


if __name__ == '__main__':
    main()
