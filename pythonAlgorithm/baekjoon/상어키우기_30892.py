import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N, K, T = map(int, input().split())
    A = list(map(int, input().split()))
    A.sort()
    feeds = []
    idx = 0
    for i in range(N):
        if K == 0: break
        if T > A[i]:
            feeds.append(A[i])
        else:
            while feeds and K != 0:
                T += feeds.pop()
                K -= 1
                if T > A[i]:
                    feeds.append(A[i])
                    break

    # 잔여 밥먹기
    while K != 0 and feeds:
        T += feeds.pop()
        K -= 1
    print(T)
