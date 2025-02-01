import sys


def main():
    input = sys.stdin.readline
    N, K, B = map(int, input().split())
    arr = [1] * N

    for _ in range(B):
        idx = int(input()) - 1
        arr[idx] = 0

    sum_arr = [sum(arr[:K])]

    for i in range(1, N - K + 1):
        n = sum_arr[i - 1] - arr[i - 1] + arr[i + K - 1]
        sum_arr.append(n)
    answer = K - max(sum_arr)
    print(answer)

if __name__ == '__main__':
    main()
