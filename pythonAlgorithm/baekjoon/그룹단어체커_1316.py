import sys
from collections import Counter

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    answer = N
    for _ in range(N):
        A = input()
        group = Counter()
        for i in range(len(A)):
            if not group.get(A[i]):
                group.update(A[i])
                continue
            if A[i - 1] == A[i]:
                continue
            answer -= 1
            break

    print(answer)
