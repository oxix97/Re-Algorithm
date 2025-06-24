import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    A = []
    for _ in range(N):
        A.append(list(map(int, input().split())))
    for i in range(N - 2, -1, -1):
        for j in range(i + 1):
            print(f"i:{i}, j:{j}")
            A[i][j] += max(A[i + 1][j], A[i + 1][j + 1])
    print(A[0][0])


if __name__ == '__main__':
    main()
