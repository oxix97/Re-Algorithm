import heapq
import sys


def main():
    input = sys.stdin.readline
    K, N = map(int, input().split())
    nums = list(map(int, input().split()))
    q = []
    for num in nums:
        heapq.heappush(q, num)
    INF = 2 ** 31
    answer = 0
    count = 0
    while count < N:
        n = heapq.heappop(q)

        if answer == n:
            continue
        count += 1
        answer = n

        for num in nums:
            new_num = num * n
            if new_num >= INF:
                break
            heapq.heappush(q, new_num)
            if n % num == 0:
                break

    print(answer)


if __name__ == '__main__':
    main()
