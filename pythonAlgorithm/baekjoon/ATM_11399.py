import sys

def main():
    input = sys.stdin.readline
    N = int(input())
    arr = list(map(int,input().split()))
    arr.sort()
    total = 0
    for i in range(N):
        total += sum(arr[:i]) + arr[i]
    print(total)
if __name__ == '__main__':
    main()