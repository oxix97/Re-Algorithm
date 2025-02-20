import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    W = [0] * N
    for i in range(N):
        W[i] = int(input())
    W.sort(reverse=True)
    max_weight = 0

    for i in range(N):
        weight = W[i] * (i + 1)
        if max_weight <  weight:
            max_weight = weight

    print(max_weight)

if __name__ == '__main__':
    main()