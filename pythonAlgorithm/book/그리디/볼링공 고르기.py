import sys
from collections import Counter


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    total = N * (N - 1) // 2
    weight_count = Counter(A)
    same_weights = 0

    for count in weight_count.values():
        if count >= 2:
            same_weights += count * (count - 1) // 2

    answer = total - same_weights
    print(answer)


if __name__ == '__main__':
    main()
