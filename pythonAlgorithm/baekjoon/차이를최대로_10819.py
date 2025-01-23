import sys
from itertools import permutations

def main():
    input = sys.stdin.readline
    N = int(input())
    numbers = list(map(int,input().split()))

    answer = -1000
    for perms in permutations(numbers,N):
        sum = 0
        for i in range(N - 1):
            sum += abs(perms[i] - perms[i-1])
        answer = max(answer, sum)

    print(answer)


if __name__ == '__main__':
    main()