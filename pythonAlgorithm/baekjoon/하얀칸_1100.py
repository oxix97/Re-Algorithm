import sys

def main():
    input = sys.stdin.readline
    A = []
    for i in range(8):
        A.append(input())
    board = [[(i + j) % 2 for j in range(8)] for i in range(8)]
    answer = 0
    for i in range(8):
        for j in range(8):
            if board[i][j] == 0 and A[i][j] == 'F':
                answer += 1
    print(answer)

if __name__ == '__main__':
    main()