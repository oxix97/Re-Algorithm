import sys
from itertools import permutations
from bisect import bisect_left


def main():
    input = sys.stdin.readline
    N, d = map(int, input().split())
    arr = [i for i in range(d)]
    answer = []
    for perm in permutations(arr, d):
        result = 0
        if perm[0] == 0: continue
        idx = d - 1
        for n in perm:
            result += n * d ** idx
            idx -= 1
        if N < result:
            answer.append(result)

    answer.sort()
    if len(answer) == 0:
        print(-1)
    else:
        pos = bisect_left(answer, N)
        print(answer[pos])


if __name__ == '__main__':
    main()
