import sys


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
    parents = [0] * (N + 1)
    for i in range(1, N + 1):
        parents[i] = i

    results = []
    for _ in range(M):
        op, a, b = map(int, input().split())
        if op == 0:
            union(a, b)
        if op == 1:
            if find(a) == find(b):
                results.append("YES")
            else:
                results.append("NO")

    for result in results:
        print(result)


if __name__ == '__main__':
    main()

# 7 8
# 0 1 3
# 1 1 7
# 0 7 6
# 1 7 1
# 0 3 7
# 0 4 2
# 0 1 1
# 1 1 1
