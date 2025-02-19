import sys


def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    woods = list(map(int, input().split()))
    left = 0
    right = max(woods)
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        result = cut(woods,mid,M)
        if result >= M:
            answer = mid
            left = mid + 1
        else:

            right = mid - 1
    print(answer)


def cut(woods, height, M):
    total = 0
    for wood in woods:
        if wood > height:
            total += wood - height
        if total > M: break

    return total


if __name__ == '__main__':
    main()
