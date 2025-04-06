import sys
import heapq

if __name__ == '__main__':
    input = sys.stdin.readline
    N, K = map(int, input().split())
    J = []
    B = []
    for _ in range(N):
        m, v = map(int, input().split())
        J.append((m, v))
    J.sort()
    for _ in range(K):
        B.append(int(input()))
    B.sort()

    idx = 0
    total_price = 0
    max_heap = []
    for bag in B:
        while idx < N and J[idx][0] <= bag:
            heapq.heappush(max_heap, -J[idx][1])
            idx += 1
        if max_heap:
            total_price += (heapq.heappop(max_heap) * -1)

    print(total_price)
