import sys, heapq


def main():
    input = sys.stdin.readline
    N = int(input())
    q = []
    for _ in range(N):
        d, w = map(int, input().split())
        heapq.heappush(q, (-w, d))

    P = [0] * 1001
    while q:
        w, d = heapq.heappop(q)
        w *= -1
        while d > 0:
            if P[d] < w: break
            d -= 1

        if d == 0: continue
        P[d] = w

    print(sum(P))

if __name__ == '__main__':
    main()
