import sys
from itertools import combinations
if __name__ == '__main__':
    input = sys.stdin.readline
    A = []
    for _ in range(9):
        A.append(int(input()))
    for comb in combinations(A,7):
        if sum(comb) == 100:
            for com in comb:
                print(com)

