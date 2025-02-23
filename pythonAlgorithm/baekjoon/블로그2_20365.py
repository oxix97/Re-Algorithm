import sys
from collections import Counter


def main():
    input = sys.stdin.readline
    N = int(input())
    blog = input().strip()
    target = blog[0]
    for i in range(1, N):
        if blog[i - 1] != blog[i]:
            target += blog[i]
    counter = Counter(target)
    most_common = counter.most_common()
    if len(most_common) == 1:
        print(1)
        return
    answer = counter[1][1] + 1
    print(answer)


if __name__ == '__main__':
    main()
