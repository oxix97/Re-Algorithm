import sys
from collections import Counter
if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    C = Counter(B)
    D = Counter(A)
    print(sum((C- D).values()))