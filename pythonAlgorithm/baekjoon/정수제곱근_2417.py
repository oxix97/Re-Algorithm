import math
import sys


def main():
    input = sys.stdin.readline
    n = int(input())
    left = 0
    right = 2 ** 32 - 1
    answer = right
    while left <= right:
        mid = (left + right) // 2
        num = mid**2
        if num < n:
            left = mid + 1
        else:
            answer = mid
            right = mid - 1
    print(answer)


if __name__ == '__main__':
    main()
