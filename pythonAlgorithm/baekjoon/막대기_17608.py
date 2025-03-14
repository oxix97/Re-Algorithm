import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    A = []
    for i in range(N):
        A.append(int(input()))
    stick = 0
    answer = 0
    while A:
        h = A.pop()
        if h > stick:
            answer += 1
            stick = h
    print(answer)