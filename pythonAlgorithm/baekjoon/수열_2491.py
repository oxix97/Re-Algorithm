import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int, input().split()))
    increase = [1] * N
    decrease = [1] * N

    for i in range(1, N):
        if A[i - 1] <= A[i]:
            increase[i] = increase[i - 1] + 1
        if A[i - 1] >= A[i]:
            decrease[i] = decrease[i - 1] + 1
    print(max(max(increase), max(decrease)))
