import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    parent = list(map(int, input().split()))
    R = int(input())
    root = parent.index(-1)

    black = [0] * N
    for i in range(N):
        idx = i
        while True:
            if idx == R:
                black[i] = 1
                break
            if idx == root: break

            idx = parent[idx]

    red = [0] * N
    for i in range(N):
        if black[i] == 1 or i == root: continue
        red[parent[i]] = 1

    answer = 0
    for i in range(N):
        if black[i] == 1 or red[i] == 1:
            continue
        answer += 1

    print(answer)

if __name__ == '__main__':
    main()
