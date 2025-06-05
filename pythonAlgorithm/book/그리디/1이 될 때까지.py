def main():
    N, K = map(int, input().split())
    answer = 0

    while N >= K:
        remainder = N % K
        answer += remainder
        N -= remainder
        N //= K
        answer += 1

    answer += N - 1
    print(answer)


if __name__ == '__main__':
    main()
