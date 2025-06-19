import sys, heapq


def main():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    A = []
    V = []
    for i in range(N):
        line = list(map(int, input().split()))
        A.append(line)
        for j in range(N):
            if A[i][j] != 0:
                heapq.heappush(V, (1, A[i][j], i, j))

    S, Y, X = map(int, input().split())
    X, Y = X - 1, Y - 1
    D = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    while V:
        time, virus, y, x = heapq.heappop(V)
        if time > S: break
        for dy, dx in D:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < N and A[ny][nx] == 0:
                A[ny][nx] = virus
                heapq.heappush(V, (time + 1, virus, ny, nx))
    print(A[Y][X])


if __name__ == '__main__':
    main()
