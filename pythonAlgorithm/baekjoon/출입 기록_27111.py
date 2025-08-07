import sys

input = sys.stdin.readline

N = int(input())
arr = [False] * 200_001
count = 0
for _ in range(N):
    a, b = map(int, input().split())
    b = True if b == 1 else False

    if arr[a] == b:
        count += 1

    arr[a] = b

count += arr.count(True)
print(count)
