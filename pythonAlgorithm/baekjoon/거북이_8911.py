import sys


def main():
    input = sys.stdin.readline
    T = int(input())
    dir = [(1, 0), (0, 1), (-1, 0), (0, -1)]  # 북, 동, 남, 서

    for _ in range(T):
        now = 0  # 북쪽 방향으로 시작
        x = 0
        y = 0
        min_x = 0  # 시작 위치 포함
        min_y = 0
        max_x = 0
        max_y = 0

        prob = input().strip()
        for p in prob:
            if p == 'L':
                now = (now + 3) % 4  # 왼쪽 회전
            elif p == 'R':
                now = (now + 1) % 4  # 오른쪽 회전
            elif p == 'F':
                x += dir[now][0]
                y += dir[now][1]
            elif p == 'B':
                x -= dir[now][0]
                y -= dir[now][1]

            min_x = min(min_x, x)
            min_y = min(min_y, y)
            max_x = max(max_x, x)
            max_y = max(max_y, y)

        answer = (max_x - min_x) * (max_y - min_y)
        print(answer)


if __name__ == '__main__':
    main()
