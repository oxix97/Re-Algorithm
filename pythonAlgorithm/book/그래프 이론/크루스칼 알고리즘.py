import sys,heapq

def main():
    def find(parent, x):
        if parent[x] != x:
            parent[x] = find(parent, parent[x])
        return parent[x]

    def union(parent, a, b):
        a = find(parent, a)
        b = find(parent, b)
        if a < b:
            parent[b] = a
        else:
            parent[a] = b

    input = sys.stdin.readline
    V, E = map(int, input().split())
    parent = [0] * (V + 1)
    edges = []

    for i in range(1, V + 1):
        parent[i] = i

    for _ in range(E):
        a, b, c = map(int, input().split())
        heapq.heappush(edges,(c,a,b))

    result = 0
    while edges:
        cost, a, b = heapq.heappop(edges)
        if find(parent,a) != find(parent,b):
            union(parent,a,b)
            result += cost

    print(result)


if __name__ == '__main__':
    main()
