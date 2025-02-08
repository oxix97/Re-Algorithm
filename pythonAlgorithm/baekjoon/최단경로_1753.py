import sys
from queue import PriorityQueue
from collections import defaultdict


def main():
    input = sys.stdin.readline
    V, E = map(int, input().split())
    K = int(input())
    graph = defaultdict(list)
    for _ in range(E):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))

    pq = PriorityQueue()
    dist = [1e9] * (V + 1)
    dist[K] = 0
    pq.put((0, K))
    while not pq.empty():
        d, u = pq.get()
        if d > dist[u]: continue
        for v, w in graph[u]:
            if dist[v] > dist[u] + w:
                dist[v] = dist[u] + w
                pq.put((dist[v], v))

    for v in dist[1:]:
        if v == 1e9:
            print("INF")
        else:
            print(v)


if __name__ == '__main__':
    main()
