import sys

def main():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int,input().split()))
    A.sort()
    print(A[(N - 1) // 2])


if __name__ == '__main__':
    main()