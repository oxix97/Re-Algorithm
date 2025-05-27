import sys
from collections import deque


def main():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    MAX_VALUE = 100_000
    visited = [False] * (MAX_VALUE + 1)
    q = deque()
    q.append((N, 0))
    visited[N] = True

    while q:
        now, time = q.popleft()
        if now == K:
            print(time)
            break

        if now * 2 <= MAX_VALUE and not visited[now * 2]:
            visited[now * 2] = True
            q.appendleft((now * 2, time))

        for next in [now - 1, now + 1]:
            if 0 <= next <= MAX_VALUE and not visited[next]:
                visited[next] = True
                q.append((next, time + 1))

if __name__ == '__main__':
    main()
