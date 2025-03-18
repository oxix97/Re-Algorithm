import sys
from collections import Counter, defaultdict

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())

    A = [[0, 0, 0, i] for i in range(3)]
    for i in range(N):
        a, b, c = map(int, input().split())
        for idx, score in enumerate([a, b, c]):
            A[idx][0] += score
            if score == 3:
                A[idx][1] += 1
            elif score == 2:
                A[idx][2] += 1

    A.sort(key=lambda x: (x[0], x[1], x[2]), reverse=True)
    if A[0][:3] == A[1][:3]:
        print(f"{0} {A[0][0]}")
    else:
        print(f"{A[0][3] + 1} {A[0][0]}")
