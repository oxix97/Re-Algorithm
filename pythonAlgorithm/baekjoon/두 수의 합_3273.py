import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    X = int(input())
    A.sort()
    answer = 0
    left = 0
    right = N - 1
    while left < right:
        v = A[left] + A[right]
        if v == X:
            answer += 1
            left += 1
            right -= 1
        elif v < X:
            left += 1
        else:
            right -= 1
    print(answer)


if __name__ == '__main__':
    main()
