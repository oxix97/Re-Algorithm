import sys

def main():
    input = sys.stdin.readline
    N,jimin,hansu = map(int,input().split())
    A = [False] * 100_001
    A[jimin] = True
    A[hansu] = True

    answer = 1
    loop = True
    while loop:
        if N % 2 == 1:
            N += 1

        for i in range(1, N + 1, 2):
            if A[i] and A[i + 1]:
                loop = False
                print(answer)
                break

        A[jimin] = False
        A[hansu] = False

        if jimin % 2 == 1:
            jimin += 1
        if hansu % 2 == 1:
            hansu += 1

        jimin //= 2
        hansu //= 2

        A[jimin] = True
        A[hansu] = True

        N //= 2
        answer += 1





if __name__ == '__main__':
    main()