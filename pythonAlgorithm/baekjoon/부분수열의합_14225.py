import sys
from itertools import combinations

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    S = list(map(int, input().split()))
    answer = set()
    for i in range(1, N + 1):
        for comb in combinations(S, i):
            answer.add(sum(comb))

    min_value = 1
    while True:
        if min_value not in answer:
            print(min_value)
            break
        min_value += 1
