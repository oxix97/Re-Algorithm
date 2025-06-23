import sys, heapq


def main():
    input = sys.stdin.readline
    N = int(input())
    q = []
    for _ in range(N):
        heapq.heappush(q, int(input()))

    total = 0
    while len(q) > 1:
        a = heapq.heappop(q)
        b = heapq.heappop(q)
        heapq.heappush(q, a + b)
        total += (a + b)

    print(total)


if __name__ == '__main__':
    main()
