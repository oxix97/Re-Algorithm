import sys, heapq

INF = int(1e9)
D = [(1, 0), (-1, 0), (0, 1), (0, -1)]


def solution(n, arr):
    distance = [[INF for _ in range(n)] for _ in range(n)]
    distance[0][0] = arr[0][0]
    q = []
    heapq.heappush(q, (arr[0][0], 0, 0))
    while q:
        dist, y, x = heapq.heappop(q)
        if distance[y][x] < dist:
            continue
        for dy, dx in D:
            ny, nx = y + dy, x + dx
            if 0 <= ny < n and 0 <= nx < n and dist + arr[ny][nx] < distance[ny][nx]:
                distance[ny][nx] = dist + arr[ny][nx]
                heapq.heappush(q, (distance[ny][nx], ny, nx))

    return distance[n - 1][n - 1]


if __name__ == '__main__':
    input = sys.stdin.readline
    T = int(input())
    answer = []
    for _ in range(T):
        N = int(input())
        A = [list(map(int, input().split())) for _ in range(N)]
        answer.append(solution(N, A))
    for a in answer:
        print(a)
