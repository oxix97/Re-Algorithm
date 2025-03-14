import sys
import heapq

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    q = []
    for _ in range(N):
        A, B = map(int, input().split())
        if A <= B:
            heapq.heappush(q, B)
    if len(q) == 0:
        print(-1)
    else:
        print(heapq.heappop(q))
