import sys


def divisor(n):
    root = int(n ** 0.5)
    return 1 if root * root == n else 0


def main():
    input = sys.stdin.readline
    N = int(input())
    X = list(map(int, input().split()))
    result = [divisor(n) for n in X]
    print(*result)


if __name__ == '__main__':
    main()
