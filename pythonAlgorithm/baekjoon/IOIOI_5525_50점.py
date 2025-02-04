import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    M = int(input())
    S = input()
    str = "I" + "OI" * N
    length = len(str)
    answer = 0
    for i in range(M - length + 1):
        tmp = S[i:i + length]
        if str==tmp:
            answer += 1
    print(answer)

if __name__ == '__main__':
    main()
