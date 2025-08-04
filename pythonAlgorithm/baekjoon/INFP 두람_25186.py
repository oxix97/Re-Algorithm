import sys

input = sys.stdin.readline
N = int(input())
D = list(map(int, input().split()))

total = sum(D)
if total != 1 and max(D) > total // 2:
    print("Unhappy")
else:
    print('Happy')
