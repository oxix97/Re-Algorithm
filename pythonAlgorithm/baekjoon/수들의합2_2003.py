import sys

def main():
    input = sys.stdin.readline
    N, M = map(int, input().split())
    A = list(map(int, input().split()))

    i = 0
    answer = 0
    current_sum = 0

    for j in range(N):
        current_sum += A[j]

        while current_sum > M and i <= j:
            current_sum -= A[i]
            i += 1

        if current_sum == M:
            answer += 1

    print(answer)

if __name__ == '__main__':
    main()
