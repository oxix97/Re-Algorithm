import sys

if __name__ == '__main__':
    N = int(input())
    arr = list(map(int,input().split()))

    total = int(input())
    left = 0
    right = max(arr)

    if right * N <= total:
        print(right)
        sys.exit()

    answer = -1
    while left <= right:
        mid = (left + right) // 2

        sum = 0
        for num in arr:
            sum += min(num,mid)

        if sum <= total:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1

    print(answer)








