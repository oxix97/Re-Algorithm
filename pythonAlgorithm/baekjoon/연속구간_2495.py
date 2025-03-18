import sys

if __name__ == '__main__':
    answer = []
    for _ in range(3):
        A = input()
        piv = 1
        max_length = 1
        for i in range(1, len(A)):
            if A[i] == A[i - 1]:
                piv += 1
            else:
                piv = 1
            max_length = max(max_length, piv)
        answer.append(max_length)
    for i in range(3):
        print(answer[i])