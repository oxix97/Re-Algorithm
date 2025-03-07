import heapq
import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    q = []
    for _ in range(N):
        items = list(map(int, input().split()))
        for item in items:
            if len(q) < N:
                heapq.heappush(q, item)
            else:
                if q[0] < item:
                    heapq.heappush(q, item)
                    heapq.heappop(q)

    print(q[0])
