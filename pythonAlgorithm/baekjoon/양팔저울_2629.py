import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))
dp = {0}

for a in A:
    tmp = set()
    for d in dp:
        tmp.add(d + a)
        tmp.add(abs(d - a))

    dp.update(tmp)

result = []
for b in B:
    if b in dp:
        result.append("Y")
    else:
        result.append("N")

print(*result)
