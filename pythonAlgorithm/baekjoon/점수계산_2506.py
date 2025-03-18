import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    point = 1
    total = 0
    for p in A:
        if p == 0:
            point = 1
            continue
        total += point
        point += 1
    print(total)
