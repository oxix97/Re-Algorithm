import math
import sys
from itertools import permutations

if __name__ == '__main__':

    input = sys.stdin.readline
    a, b = map(int, input().split())
    A = []
    for _ in range(3):
        y, x = map(int, input().split())
        A.append((y, x))

    min_value = 1e9
    for p in permutations(A, 3):
        tmp = 0
        y, x = a, b
        for i in range(3):
            tmp += math.sqrt((y - p[i][0])**2 + (x - p[i][1])**2)
            y, x = p[i][0], p[i][1]
        min_value = min(min_value, tmp)
    print(int(min_value))
