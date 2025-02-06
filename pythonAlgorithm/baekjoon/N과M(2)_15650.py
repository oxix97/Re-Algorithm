import sys
from itertools import combinations


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    arr = [i for i in range(1, N + 1)]
    answer = list(combinations(arr, M))
    answer.sort()
    for item in answer:
        print(*item)

if __name__ == '__main__':
    main()
