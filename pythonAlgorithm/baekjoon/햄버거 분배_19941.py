import sys

if __name__ == '__main__':
    input = sys.stdin.readline

    N, K = map(int, input().split())
    PH = list(input())
    cnt = 0
    for i in range(N):
        if PH[i] == 'P':
            for idx in range(max(i - K, 0), min(i + K + 1, N)):
                if PH[idx] == 'H':
                    PH[idx] = 'X'
                    cnt += 1
                    break
    print(cnt)
