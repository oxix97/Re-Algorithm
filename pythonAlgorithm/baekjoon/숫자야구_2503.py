import sys
from itertools import permutations

def main():
    def check(question, target):
        strike = 0
        ball = 0
        for i in range(3):
            if question[i] == target[i]:
                strike += 1
            elif question[i] in target:
                ball += 1

        return strike, ball

    input = sys.stdin.readline
    N = int(input())

    permutation = list(permutations(range(1, 10), 3))

    for i in range(N):
        Q, S, B = map(int, input().split())
        question = [int(i) for i in str(Q)]
        tmp = []
        for perm in permutation:
            strike, ball = check(question, perm)
            if strike == S and ball == B:
                tmp.append(perm)
        permutation = tmp

    print(len(permutation))

if __name__ == '__main__':
    main()
