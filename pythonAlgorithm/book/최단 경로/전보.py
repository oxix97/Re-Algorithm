import sys, heapq
from collections import defaultdict


def main():
    input = sys.stdin.readline
    INF = 1e9
    N, M, C = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(M):
        X, Y, Z = map(int, input().split())
        graph[X].append((Z, Y))
    q = []
    distance = [INF] * (N + 1)
    distance[C] = 0
    heapq.heappush(q, (0, C))

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist: continue

        for cost, next in graph[now]:
            new_dist = dist + cost
            if new_dist < distance[next]:
                distance[next] = new_dist
                heapq.heappush(q, (new_dist, next))

    total_count = 0
    max_distance = 0
    for dist in distance:
        if dist == INF or dist == 0: continue
        total_count += 1
        max_distance = max(max_distance,dist)

    print(f"{total_count} {max_distance}")


if __name__ == '__main__':
    main()
