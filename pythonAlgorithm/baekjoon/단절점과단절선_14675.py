import sys

# 단절점 : 리프 노드가 아닌 것들
# 단절선 : 모든 선이 단절선

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    cnt = [0 for i in range(N + 1)]
    for _ in range(N - 1):
        a, b = map(int, input().split())
        cnt[a] += 1
        cnt[b] += 1

    Q = int(input())
    for _ in range(Q):
        t, k = map(int, input().split())
        if t == 1 and cnt[k] == 1:
            print("no")
        else:
            print("yes")
