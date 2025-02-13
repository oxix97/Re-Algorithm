import sys
from collections import defaultdict, deque


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    graph = defaultdict(list)
    arr = [0] * (N + 1)
    for _ in range(M):
        A, B = map(int, input().split())
        graph[A].append(B)
        arr[B] += 1

    q = deque()
    for i in range(1,N + 1):
        if arr[i] == 0:
            q.append(i)

    answer = []
    while q:
        v = q.popleft()
        answer.append(v)

        for idx in graph[v]:
            arr[idx] -= 1
            if arr[idx] == 0:
                q.append(idx)

    print(*answer)



if __name__ == '__main__':
    main()
