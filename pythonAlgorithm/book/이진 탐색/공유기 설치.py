import sys


def main():
    def count_distance(dist):
        last = A[0]
        count = 1
        for i in range(1, N):
            if A[i] - last >= dist:
                count += 1
                last = A[i]
        return count

    input = sys.stdin.readline
    N, C = map(int, input().split())
    A = [int(input()) for _ in range(N)]
    A.sort()
    min_dist, max_dist = 1, A[N - 1] - A[0]
    answer = 0

    while min_dist <= max_dist:
        mid_dist = (min_dist + max_dist) // 2
        if count_distance(mid_dist) >= C:
            answer = mid_dist
            min_dist = mid_dist + 1
        else:
            max_dist = mid_dist - 1

    print(answer)


if __name__ == '__main__':
    main()
