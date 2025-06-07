import sys
from bisect import bisect_left

def main():
    def binary_search(item):
        pos = bisect_left(A,item)
        find = 'no'
        if pos <= len(A) and A[pos] == item:
            find = 'yes'
        return find

    input = sys.stdin.readline
    N = int(input())
    A = list(map(int,input().split()))
    A.sort()
    M = int(input())
    B = list(map(int,input().split()))

    answer = []
    for b in B:
        answer.append(binary_search(b))
    print(*answer)


if __name__ == '__main__':
    main()