import sys
from collections import Counter,defaultdict

input = sys.stdin.readline
N, M = map(int, input().split())
A = [int(input()) for _ in range(N)]
B = [int(input()) for _ in range(M)]
D = defaultdict(int)

for cost in B:
    for i in range(N):
        if cost >= A[i]:
            D[i + 1] += 1
            break

a = Counter(D)
print(a.most_common()[0][0])