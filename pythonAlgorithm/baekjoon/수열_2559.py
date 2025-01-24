import sys

def main():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    total = sum(arr[:K])
    answer = total
    for i in range(1, N + 1 - K):
        prev = arr[i - 1]
        post = arr[K - 1 + i]
        total += post - prev
        answer = max(answer, total)

    print(answer)

if __name__ == '__main__':
    main()
