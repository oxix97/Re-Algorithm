import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    arr = []
    for _ in range(N):
        arr.append(int(input()))

    answer = 0
    arr.reverse()
    for i in range(1, N):
        if arr[i - 1] <= arr[i]:
            tmp = arr[i] - arr[i -1] + 1
            arr[i] -= tmp
            answer += tmp
    print(answer)

if __name__ == '__main__':
    main()
