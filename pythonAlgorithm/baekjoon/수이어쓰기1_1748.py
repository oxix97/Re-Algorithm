import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    start = 1
    end = len(str(N))
    total = 0
    tmp = N
    while True:
        v = 10 ** (start - 1)
        if start == end:
            total += (N - v) * start
            total += 1
            break
        else:
            total += 9 * v * start
            total += 1
        start += 1
        tmp //= v

    print(total)


if __name__ == '__main__':
    main()
