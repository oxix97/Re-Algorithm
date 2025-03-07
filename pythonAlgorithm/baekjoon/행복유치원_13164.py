import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N, K = map(int, input().split())
    A = list(map(int, input().split()))

    B = [A[i + 1] - A[i] for i in range(N - 1)]
    B.sort(reverse=True)
    answer = A[-1] - A[0]

    for i in range(K - 1):
        answer -= B[i]
    print(answer)
