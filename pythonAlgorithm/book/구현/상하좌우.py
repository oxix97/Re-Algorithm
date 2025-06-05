import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    commands = list(input().split())

    directions = {'U': (-1, 0), 'D': (1, 0), 'L': (0, -1), 'R': (0, 1)}
    x, y = 1, 1

    for command in commands:
        dx, dy = directions[command]
        nx, ny = x + dx, y + dy

        if 1 <= nx <= N and 1 <= ny <= N:
            x, y = nx, ny

    print(x, y)


if __name__ == '__main__':
    main()
