import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    A = []
    for i in range(N):
        x, y = map(int, input().split())
        A.append((x, y))
    ranks = [1] * N
    for i in range(N):
        for j in range(N):
            if i == j: continue
            if A[i][0] > A[j][0] and A[i][1] > A[j][1]:
                ranks[j] += 1
    print(*ranks)


if __name__ == '__main__':
    main()
