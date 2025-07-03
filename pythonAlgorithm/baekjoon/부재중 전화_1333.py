import sys


def main():
    input = sys.stdin.readline
    N, L, D = map(int, input().split())
    check = [False for _ in range(5000)]
    idx = 0
    for _ in range(N):
        for _ in range(L):
            check[idx] = True
            idx += 1

        idx += 5

    for i in range(0, 5000, D):
        if not check[i]:
            print(i)
            break


if __name__ == '__main__':
    main()

# 0 1 2 3 4 5 6 7 8 9
# 10 11 12 13 14
# 15 16 17 18 19 20 21 22 23
# 24 25 26 27 28
# 29 30 31 32 33 34 35 36 37
# 38 39 40 41 42
