import sys

def main():
    N = int(input())
    A = [int(input()) for _ in range(N)]
    A.sort(reverse=True)
    print(*A)

if __name__ == '__main__':
    main()