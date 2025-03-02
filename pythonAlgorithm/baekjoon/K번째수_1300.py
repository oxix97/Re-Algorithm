import sys
if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    K = int(input())
    left = 1
    right = N**2
    answer = 0
    while left<=right:
        mid = (left + right) // 2
        count = 0
        for i in range(1,N + 1):
            count += min(N,(mid - 1) // i)
        if count < K:
            left = mid + 1
            answer = mid
        else:
            right = mid - 1
    print(answer)
