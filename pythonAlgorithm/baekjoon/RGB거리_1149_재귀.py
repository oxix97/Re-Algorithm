import sys

if __name__ == '__main__':
    def recursion(n, color):
        global answer
        if answer[n][color] != 0:
            return answer[n][color]

        idx = [0, 1, 2]
        idx.remove(color)
        answer[n][color] = min(recursion(n - 1, idx.pop()), recursion(n - 1, idx.pop())) + A[n][color]

        return answer[n][color]

    input = sys.stdin.readline
    N = int(input())
    A = []
    for i in range(N):
        A.append(list(map(int, input().split())))
    answer = [[0 for j in range(N)] for i in range(N)]
    answer[0][0] = A[0][0]
    answer[0][1] = A[0][1]
    answer[0][2] = A[0][2]
    min_value = min(recursion(N - 1, 0), recursion(N - 1, 1), recursion(N - 1, 2))
    print(min_value)
