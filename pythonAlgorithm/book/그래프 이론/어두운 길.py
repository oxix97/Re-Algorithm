import sys, heapq

def main():
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    def union(a, b):
        a = find(a)
        b = find(b)
        if a < b:
            parent[b] = a
        else:
            parent[a] = b

    input = sys.stdin.readline
    N, M = map(int, input().split())
    parent = [i for i in range(N)]
    total_cost = 0
    result = 0
    q = []
    for _ in range(M):
        X, Y, Z = map(int, input().split())
        heapq.heappush(q, (Z, X, Y))
        total_cost += Z

    while q:
        cost, a, b = heapq.heappop(q)
        if find(a) != find(b):
            union(a, b)
            result += cost

    print(total_cost - result)


if __name__ == '__main__':
    main()

# 7 11
# 0 1 7
# 0 3 5
# 1 2 8
# 1 3 9
# 1 4 7
# 2 4 5
# 3 4 15
# 3 5 6
# 4 5 8
# 4 6 9
# 5 6 11