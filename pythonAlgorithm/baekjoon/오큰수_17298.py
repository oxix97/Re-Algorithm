import sys

def main():
    input = sys.stdin.readline
    N = int(input())
    A = list(map(int,input().split()))
    A.reverse()
    stack = []
    answer = []
    for i in range(N):
        while len(stack) != 0 and A[i] >= stack[-1]:
            stack.pop()
        if len(stack) == 0:
            answer.append(-1)
        else:
            answer.append(stack[-1])
        stack.append(A[i])
    answer.reverse()
    print(*answer)

if __name__ == '__main__':
    main()