import sys


def main():
    input = sys.stdin.readline
    n = int(input())
    arr = list(map(int, input().split()))
    x = int(input())

    left = 0
    right = n - 1
    arr.sort()
    answer = 0
    while left != right:
        sum = arr[left] + arr[right]
        if sum < x:
            left += 1
        else:
            right -= 1
        if sum == x: answer += 1
    print(answer)

if __name__ == '__main__':
    main()
