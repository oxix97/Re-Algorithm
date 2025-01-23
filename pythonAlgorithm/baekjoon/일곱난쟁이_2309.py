import sys
from itertools import combinations

def main():
    input = sys.stdin.readline
    arr = []
    for _ in range(9):
        arr.append(int(input()))

    comb = list(combinations(arr,7))
    targets = list(findTargets(comb))
    targets.sort()
    for target in targets:
        print(target)

def findTargets(comb):
    for com in comb:
        if sum(com) == 100:
            return com
if __name__ == '__main__':
    main()