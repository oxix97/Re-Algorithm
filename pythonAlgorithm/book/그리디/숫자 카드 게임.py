import sys


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    A = [list(map(int, input().split())) for _ in range(N)]
    answer = 0
    for i in range(N):
        answer = max(answer,min(A[i]))
    print(answer)

if __name__ == '__main__':
    main()
