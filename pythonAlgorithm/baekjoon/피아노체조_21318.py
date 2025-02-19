import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    arr = list(map(int, input().split()))
    if N == 1:
        Q = int(input())
        for _ in range(Q):
            print(0)
        return

    mistake = [1 if arr[i] > arr[i + 1] else 0 for i in range(N - 1)]
    p_sum = [0] * (N - 1)
    p_sum[0] = mistake[0]

    for i in range(1, N - 1):
        p_sum[i] = p_sum[i - 1] + mistake[i]

    Q = int(input())
    for _ in range(Q):
        x, y = map(int, input().split())
        if x == y:
            print(0)
            continue
        if x == 1:
            answer = p_sum[y - 2]
        else:
            answer = p_sum[y - 2] - p_sum[x - 2]
        print(answer)


if __name__ == '__main__':
    main()
