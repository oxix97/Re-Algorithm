import sys
from collections import defaultdict

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    A = input().strip()
    left = 0
    right = 0
    S = defaultdict(int)
    answer = 0
    while right < len(A):
        S[A[right]] += 1
        right += 1

        while len(S) > N:
            S[A[left]] -= 1
            if S[A[left]] == 0:
                del S[A[left]]
            left += 1

        answer = max(answer, right - left)
    print(answer)
