import sys
import heapq

if __name__ == '__main__':
    input = sys.stdin.readline
    N, X = map(int, input().split())
    q = []
    for _ in range(N):
        S, T = map(int, input().split())
        if X >= S + T:
            heapq.heappush(q, S * -1)
    if len(q) == 0:
        print(-1)
    else:
        print(heapq.heappop(q) * -1)
