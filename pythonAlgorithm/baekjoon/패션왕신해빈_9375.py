import sys
from collections import defaultdict

if __name__ == '__main__':
    input = sys.stdin.readline
    T = int(input())
    case = defaultdict(list)
    for _ in range(T):
        N = int(input())
        cnt = 1
        for _ in range(N):
            a, b = map(str, input().split())
            case[b].append(a)

        for key in case.keys():
            cnt *= (len(case[key]) + 1)
        cnt -= 1
        print(cnt)
        case.clear()

