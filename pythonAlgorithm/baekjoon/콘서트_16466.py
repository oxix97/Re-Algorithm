import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    for i in range(1, N + 1):
        if i != arr[i - 1]:
            print(i)
            exit(0)
    print(arr[N - 1] + 1)
