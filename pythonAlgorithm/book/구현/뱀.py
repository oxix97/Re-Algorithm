import sys
from collections import deque


def main():
    def is_end(y, x):
        if y < 1 or y > N or x < 1 or x > N:
            return True
        if board[y][x] == 2:
            return True
        return False

    input = sys.stdin.readline
    N = int(input())
    K = int(input())
    board = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
    for _ in range(K):
        y, x = map(int, input().split())
        board[y][x] = 1
    L = int(input())
    cmd = {}
    for _ in range(L):
        x, c = input().split()
        cmd[int(x)] = c
    dy = [-1, 0, 1, 0]
    dx = [0, 1, 0, -1]
    dir = 1
    time = 0
    q = deque()
    q.append((1, 1))
    y = 1
    x = 1
    board[1][1] = 2
    while True:
        time += 1

        ny = dy[dir] + y
        nx = dx[dir] + x

        if is_end(ny, nx): break
        has_apple = (board[ny][nx] == 1)

        q.appendleft((ny, nx))
        board[ny][nx] = 2
        y, x = ny, nx

        if not has_apple:
            tail_y, tail_x = q.pop()
            board[tail_y][tail_x] = 0

        if cmd.get(time) == "D":
            dir = (dir + 1) % 4
        elif cmd.get(time) == "L":
            dir = (dir - 1) % 4

    print(time)


if __name__ == '__main__':
    main()
