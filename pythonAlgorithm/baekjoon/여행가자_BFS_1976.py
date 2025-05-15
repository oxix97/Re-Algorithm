import sys
from collections import defaultdict,deque


def main():
    input = sys.stdin.readline
    N = int(input())
    M = int(input())
    A = defaultdict(list)
    for i in range(1,N + 1):
        tmp = list(map(int, input().split()))
        for j in range(N):
            if tmp[j] == 1:
                A[i].append(j + 1)

    plan = list(map(int, input().split()))
    visited = [False] * (N + 1)
    q = deque()
    q.append(plan[0])
    visited[plan[0]] = True
    while q:
        now = q.popleft()
        for next in A[now]:
            if not visited[next]:
                visited[next] = True
                q.append(next)

    answer = "YES"
    for p in plan:
        if not visited[p]:
            answer = "NO"
    print(answer)

if __name__ == '__main__':
    main()
