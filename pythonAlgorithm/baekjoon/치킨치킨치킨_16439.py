import sys
from itertools import combinations

if __name__ == '__main__':
    input = sys.stdin.readline
    N, M = map(int, input().split())
    A = []
    for i in range(N):
        A.append(list(map(int, input().split())))
    answer = 0

    for comb in combinations([i for i in range(M)], 3):
        total = 0
        for i in range(N):
            max_value = 0
            for j in range(3):
                if max_value < A[i][comb[j]]:
                    max_value = A[i][comb[j]]
            total += max_value
        answer = max(answer, total)
    print(answer)
