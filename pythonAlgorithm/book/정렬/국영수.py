import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    A = []
    for _ in range(N):
        name, kor, eng, math = input().split()
        A.append((int(kor), int(eng), int(math), name))
    result = sorted(A, key=lambda x: (-x[0], x[1], -x[2], x[3]))
    for ans in result:
        print(ans[3])


if __name__ == '__main__':
    main()
