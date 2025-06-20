import sys
from collections import deque


def main():
    def is_invalid(y, x):
        return y < 0 or y >= N or x < 0 or x >= N

    # 3. 한 명이라도 발견하는 경우 감시 성공
    def find_student():
        for y, x in teachers:
            for dy, dx in D:
                ny, nx = y + dy, x + dx
                while True:
                    if is_invalid(ny, nx) or A[ny][nx] == 'O': break
                    if A[ny][nx] == 'S': return True
                    ny += dy
                    nx += dx

        return False

    def recursion(cnt):
        # 2. 감시 하기
        nonlocal answer
        if cnt == 0:
            find = find_student()
            if not find:
                answer = 'YES'
            return

        # 1. 장애물 3개 놓기
        for i in range(N):
            for j in range(N):
                if A[i][j] == 'X':
                    A[i][j] = 'O'
                    recursion(cnt - 1)
                    A[i][j] = 'X'

    input = sys.stdin.readline
    N = int(input())
    D = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    A = [list(input().split()) for _ in range(N)]
    teachers = [(i, j) for i in range(N) for j in range(N) if A[i][j] == 'T']
    answer = 'NO'
    recursion(3)
    print(answer)


if __name__ == '__main__':
    main()
