import sys
from itertools import permutations, combinations

if __name__ == '__main__':
    input = sys.stdin.readline


    def calculate(A, B):
        strike = 0
        ball = 0
        for i in range(3):
            if int(A[i]) == B[i]:
                strike += 1
                continue
            if int(A[i]) in B:
                ball += 1
        return strike, ball

    N = int(input())
    q = []
    for i in range(N):
        q.append(input().split())

    count = 0
    for permutation in permutations(range(1, 10), 3):
        is_good = True
        for i in range(N):
            strike, ball = calculate(q[i][0], permutation)
            if strike != int(q[i][1]) or ball != int(q[i][2]):
                is_good = False
        if is_good:
            count += 1
    print(count)
