import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N, K = map(int, input().split())
    points = list(map(int, input().split()))
    left = 0
    right = 1e9
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        count = 0
        sum_point = 0
        for point in points:
            sum_point += point
            if sum_point >= mid:
                count += 1
                sum_point = 0

        if count >= K:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1

    print(answer)
