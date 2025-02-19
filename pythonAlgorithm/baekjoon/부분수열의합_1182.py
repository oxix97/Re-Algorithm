import sys
from itertools import combinations


def main():
    input = sys.stdin.readline
    N, S = map(int, input().split())
    arr = list(map(int, input().split()))
    answer = 0
    for i in range(1, N + 1):
        for subset in combinations(arr,i):
            if sum(subset) == S:
                answer += 1

    print(answer)

if __name__ == '__main__':
    main()
