import sys, heapq


def main():
    input = sys.stdin.readline
    N = int(input())
    P = [tuple(map(int, input().split())) for _ in range(N)]
    INF = 1e9
    dist = [[INF, INF] for _ in range(N)]
    dist[0][0] = 0
    q = []
    heapq.heappush(q, (0, 0, 0))
    while q:
        d, idx, jump = heapq.heappop(q)
        if dist[idx][jump] < d: continue

        if idx + 1 < N:
            cost = d + abs(P[idx + 1][0] - P[idx][0]) + abs(P[idx + 1][1] - P[idx][1])
            if cost < dist[idx + 1][jump]:
                dist[idx + 1][jump] = cost
                heapq.heappush(q, (cost, idx + 1, jump))

        if jump == 0 and idx + 2 < N:
            cost = d + abs(P[idx + 2][0] - P[idx][0]) + abs(P[idx + 2][1] - P[idx][1])
            if cost < dist[idx + 2][1]:
                dist[idx + 2][1] = cost
                heapq.heappush(q, (cost, idx + 2, 1))

    answer = min(dist[N - 1][0], dist[N - 1][1])
    print(answer)


if __name__ == '__main__':
    main()
