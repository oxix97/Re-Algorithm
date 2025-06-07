import sys, heapq
from collections import defaultdict


def main():
    INF = 1e9
    input = sys.stdin.readline
    N, M = map(int, input().split())
    start = int(input())
    graph = defaultdict(list)
    distance = [INF] * (N + 1)

    for _ in range(M):
        a, b, c = map(int, input().split())
        graph[a].append((c, b))

    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue

        for cost, next_node in graph[now]:
            new_dist = dist + cost
            if new_dist < distance[next_node]:
                distance[next_node] = new_dist
                heapq.heappush(q, (new_dist, next_node))

    for i in range(1, N + 1):
        if distance[i] == INF:
            print("INFINITY")
        else:
            print(distance[i])


if __name__ == '__main__':
    main()
