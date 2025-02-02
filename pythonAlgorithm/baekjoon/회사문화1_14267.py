import sys

def main():
    input = sys.stdin.readline
    n,m = map(int,input().split())
    parent = list(map(int,input().split()))
    for i in range(n):
        parent[i] -= 1

    good = [0] * n
    for _ in range(m):
        i, w = map(int, input().split())
        good[i - 1] += w

    answer = [0] * n
    for i in range(1,n):
        answer[i] = answer[parent[i]] + good[i]

    print(*answer)

if __name__ == '__main__':
    main()