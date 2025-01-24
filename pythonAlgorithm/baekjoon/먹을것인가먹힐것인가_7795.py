import sys


def main():
    input = sys.stdin.readline
    T = int(input())

    for _ in range(T):
        A, B = map(int, input().split())
        N = list(map(int, input().split()))
        M = list(map(int, input().split()))

        N.sort()
        M.sort()
        answer = 0
        ptr = 0

        for fish in N:
            while ptr < B and M[ptr] < fish:
                ptr += 1
            answer += ptr

        print(answer)

if __name__ == '__main__':
    main()
