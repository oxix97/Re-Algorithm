import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    A.sort()

    group = 0
    group_count = 0

    for a in A:
        group += 1
        if group >= a:
            group = 0
            group_count += 1

    print(group_count)


if __name__ == '__main__':
    main()
