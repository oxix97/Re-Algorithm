import sys
from collections import Counter

if __name__ == '__main__':
    input = sys.stdin.readline
    A = input().strip()
    N = len(A)
    answer = 0
    right = N - 1
    LC = 0
    RC = 0
    R = 0
    for left in range(N):
        if left > right:
            break
        if A[left] == 'K':
            LC += 1
        if A[right] == 'K':
            RC += 1
        if A[left] == 'R' or A[right] == 'R':
            R += 1
            answer = max(R + min(LC, RC) * 2, answer)
        right -= 1

    print(max(answer, Counter(A)['R']))
