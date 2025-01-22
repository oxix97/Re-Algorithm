import sys

def main():
    N, M = map(int, input().split())
    arr = list(map(int, sys.stdin.readline().split()))
    left = max(arr)
    right = sum(arr)
    answer = -1
    while left <= right:
        mid = (left + right) // 2
        tmp = mid
        cnt = 1
        for ar in arr:
            if tmp < ar:
                cnt += 1
                tmp = mid
            tmp -= ar
        if cnt > M:
            left = mid + 1
        else:
            answer = mid
            right = mid - 1
    print(answer)


if __name__ == '__main__':
    main()
