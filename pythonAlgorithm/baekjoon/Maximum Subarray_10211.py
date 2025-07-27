import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    X = list(map(int, input().split()))
    max_so_far = X[0]
    current_max = X[0]
    for i in range(1,N):
        current_max = max(X[i],current_max + X[i])
        max_so_far = max(max_so_far,current_max)

    print(max_so_far)
