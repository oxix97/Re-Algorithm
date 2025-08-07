import sys
from itertools import combinations_with_replacement

input = sys.stdin.readline
N = int(input())
T = [0, 1, 3]
for i in range(3, 100_001):
    num = T[i - 1] + i
    if num > 1000:
        break
    T.append(num)

numbers = set()
for comb in combinations_with_replacement(T[1:],3):
    numbers.add(sum(comb))

for _ in range(N):
    n = int(input())
    if n in numbers:
        print(1)
    else:
        print(0)
