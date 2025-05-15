import sys

def main():
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    def union(a, b):
        a_root = find(a)
        b_root = find(b)
        if a_root != b_root:
            parent[b_root] = a_root

    input = sys.stdin.readline
    N = int(input())
    M = int(input())
    parent = [i for i in range(N + 1)]
    for i in range(N):
        tmp = list(map(int,input().split()))
        for j in range(N):
            if tmp[j] == 1:
                union(i + 1, j + 1)

    plan = list(map(int, input().split()))
    root = find(plan[0])
    answer = "YES"
    for city in plan:
        if find(city) != root:
            answer = "NO"
            break
    print(parent)
    print(answer)

if __name__ == '__main__':
    main()
