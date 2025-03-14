if __name__ == '__main__':
    N = int(input())
    A = [i for i in range(1, N + 1)]

    while len(A) > 1:
        tmp = []
        for i in range(len(A)):
            if i % 2 == 0: continue
            tmp.append(A[i])
        A = tmp

    print(A.pop())
