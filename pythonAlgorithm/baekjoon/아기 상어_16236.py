import sys, heapq


def main():
    def find(y, x, shark):
        q = []
        heapq.heappush(q, (0, y, x))
        visited = [[False for _ in range(N)] for _ in range(N)]
        visited[y][x] = True
        while q:
            dist, y, x = heapq.heappop(q)
            if 0 < A[y][x] < shark:
                return dist, y, x
            for dy, dx in D:
                ny, nx = dy + y, dx + x
                if 0 <= ny < N and 0 <= nx < N and A[ny][nx] <= shark and not visited[ny][nx]:
                    visited[ny][nx] = True
                    heapq.heappush(q, (dist + 1, ny, nx))

        return None

    input = sys.stdin.readline
    N = int(input())
    A = [list(map(int, input().split())) for _ in range(N)]
    D = [(-1, 0), (0, -1), (1, 0), (0, 1)]
    count = 0
    time = 0
    shark = 2
    y, x = 0, 0

    for i in range(N):
        for j in range(N):
            if A[i][j] == 9:
                y, x = i, j
                break
    A[y][x] = 0

    while True:
        fish = find(y, x, shark)
        if fish is None:
            break

        dist, fy, fx = fish
        time += dist
        A[fy][fx] = 0
        count += 1

        y, x = fy, fx
        if count == shark:
            count = 0
            shark += 1

    print(time)


if __name__ == '__main__':
    main()
