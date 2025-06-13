import sys
from itertools import combinations


def main():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    A.sort()

    answer = 1
    for coin in A:
        if coin > answer:
            break
        answer += coin

    print(answer)

if __name__ == '__main__':
    main()
