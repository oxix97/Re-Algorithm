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
    N = int(input())

    planets_x = []
    planets_y = []
    planets_z = []

    for i in range(N):
        x, y, z = map(int, input().split())
        planets_x.append((x, i))
        planets_y.append((y, i))
        planets_z.append((z, i))

    planets_x.sort()
    planets_y.sort()
    planets_z.sort()

    edges = []
    for i in range(N - 1):
        cost_x = abs(planets_x[i][0] - planets_x[i + 1][0])
        heapq.heappush(edges, (cost_x, planets_x[i][1], planets_x[i + 1][1]))

        cost_y = abs(planets_y[i][0] - planets_y[i + 1][0])
        heapq.heappush(edges, (cost_y, planets_y[i][1], planets_y[i + 1][1]))

        cost_z = abs(planets_z[i][0] - planets_z[i + 1][0])
        heapq.heappush(edges, (cost_z, planets_z[i][1], planets_z[i + 1][1]))

    parent = [i for i in range(N)]
    result = 0
    count = 0

    while edges and count < N - 1:
        cost, a, b = heapq.heappop(edges)
        if find(a) != find(b):
            union(a, b)
            count += 1
            result += cost

    print(result)


if __name__ == '__main__':
    main()