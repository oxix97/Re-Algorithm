import sys


def main():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    circle = [i for i in range(1, N + 1)]

    piv = 1
    idx = 0
    answer = []
    while len(circle) != 1:
        if piv == K:
            answer.append(circle[idx])
            del circle[idx]
            piv = 0
            idx -= 1

        piv += 1
        idx = (idx + 1) % len(circle)
    answer.append(circle[0])
    print("<" + ", ".join(map(str, answer)) + ">")


if __name__ == '__main__':
    main()
