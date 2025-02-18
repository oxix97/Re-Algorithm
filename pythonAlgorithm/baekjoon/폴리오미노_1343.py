import sys


def main():
    input = sys.stdin.readline
    boards = input().split(".")
    a = "AAAA"
    b = "BB"
    answer = ""
    for board in boards:
        board_size = len(board.strip())

        a_cnt = board_size // 4
        board_size -= a_cnt * 4

        b_cnt = board_size // 2
        board_size -= b_cnt * 2

        if board_size != 0:
            print(-1)
            return

        answer += a * a_cnt
        answer += b * b_cnt
        answer += "."

    print(answer[:-1])


if __name__ == '__main__':
    main()
