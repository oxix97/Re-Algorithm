import sys
from bisect import bisect_left,bisect_right


def main():

    input = sys.stdin.readline
    dp = [1, 2]
    while True:
        result = dp[-1] + dp[-2]
        if result > 10 ** 100: break
        dp.append(result)

    while True:
        a, b = map(int, input().split())
        if a == 0 and b == 0:
            break
        print(bisect_right(dp,b) - bisect_left(dp,a))


if __name__ == '__main__':
    main()
