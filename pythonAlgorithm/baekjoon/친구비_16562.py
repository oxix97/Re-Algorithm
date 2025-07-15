import sys

input = sys.stdin.readline
N, M, K = map(int, input().split())
A = list(map(int, input().split()))
parent = [i for i in range(N)]


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if A[a] < A[b]:
        parent[b] = a
    else:
        parent[a] = b


for _ in range(M):
    v, w = map(int, input().split())
    union(v - 1, w - 1)

roots = {find(i) for i in range(N)}
price = sum(A[root] for root in roots)
if K < price:
    print("Oh no")
else:
    print(price)
