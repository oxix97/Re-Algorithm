
def main():
    cmd = input()
    dir = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2)]
    x = ord(cmd[0]) - ord('a') + 1
    y = int(cmd[1])
    answer = 0
    for d in dir:
        if 1 <= x + d[0] <= 8 and 1<= y + d[1] <= 8:
            answer += 1
    print(answer)


if __name__ == '__main__':
    main()
