import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    time = list(map(int, input().split()))
    D = int(input())
    time[2] += D % 60
    time[1] += D // 60
    for i in reversed(range(1, 3)):
        if time[i] >= 60:
            time[i - 1] += time[i] // 60
            time[i] %= 60
    if time[0] >= 24:
        time[0] %= 24
    print(*time)
