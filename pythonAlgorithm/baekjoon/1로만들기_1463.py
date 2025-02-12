import sys

def main():
    input = sys.stdin.readline
    N = int(input())
    s = [0] * (N + 1)

    for i in range(2, N + 1):
        s[i] = s[i - 1] + 1
        if i % 2 == 0:
            s[i] = min(s[i // 2] + 1, s[i])
        if i % 3 == 0:
            s[i] = min(s[i // 3] + 1, s[i])
    print(s[N])


if __name__ == '__main__':
    main()
