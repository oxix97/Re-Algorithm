import sys
from itertools import combinations


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    chickens = []
    houses = []
    for i in range(N):
        A = list(map(int, input().split()))
        for j in range(N):
            if A[j] == 1:
                houses.append((i, j))
            if A[j] == 2:
                chickens.append((i, j))

    answer = 1e9
    for comb in combinations(chickens, M):
        sum_dist = 0
        for y, x in houses:
            dist = 1e9
            for ny, nx in comb:
                dist = min(abs(y - ny) + abs(x - nx), dist)
            sum_dist += dist
        answer = min(answer, sum_dist)

    print(answer)


if __name__ == '__main__':
    main()
