import sys


def main():
    n = int(sys.stdin.readline())
    DP = [0, 1]
    for i in range(2, n + 1):
        DP.append(min([DP[i - (j ** 2)] + 1 for j in range(1, int(i ** 0.5) + 1)]))
    print(DP[n])


if __name__ == '__main__':
    main()
