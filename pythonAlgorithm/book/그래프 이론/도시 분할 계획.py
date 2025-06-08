import sys, heapq


def main():
    def find(x):
        if parents[x] != x:
            parents[x] = find(parents[x])
        return parents[x]

    def union(a, b):
        a = find(a)
        b = find(b)
        if a < b:
            parents[b] = a
        else:
            parents[a] = b

    input = sys.stdin.readline
    N, M = map(int, input().split())
    q = []
    for _ in range(M):
        a, b, c = map(int, input().split())
        heapq.heappush(q, (c, a, b))

    parents = [0] * (N + 1)
    for i in range(1, N + 1):
        parents[i] = i

    last = 0
    result = 0
    while q:
        cost, a, b = heapq.heappop(q)
        if find(a) != find(b):
            last = cost
            result += cost
            union(a, b)

    print(result - last)


if __name__ == '__main__':
    main()
