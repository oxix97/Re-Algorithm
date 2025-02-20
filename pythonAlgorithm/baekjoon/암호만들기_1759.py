import sys
from itertools import combinations


def main():
    input = sys.stdin.readline
    L, C = map(int, input().split())
    arr = list(input().split())
    arr.sort()
    comb = list(combinations(arr, L))
    comb.sort()
    set(comb)
    aeiou = ('a', 'e', 'i', 'o', 'u')
    for c in comb:
        cnt = len(set(c).intersection(aeiou))
        if cnt >= 1 and len(c) - cnt >= 2:
            print(''.join(c).strip())


if __name__ == '__main__':
    main()
