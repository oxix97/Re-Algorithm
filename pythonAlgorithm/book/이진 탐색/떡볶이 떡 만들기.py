import sys

def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    H = list(map(int, input().split()))
    left = 0
    right = max(H)
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        result = sum(max(0, h - mid) for h in H)

        if result < M:
            right = mid - 1
        else:
            answer = mid
            left = mid + 1
    print(answer)
if __name__ == '__main__':
    main()
