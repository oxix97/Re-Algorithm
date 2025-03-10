import sys

if __name__ == '__main__':
    def exit_solution():
        print("NO")
        sys.exit()


    input = sys.stdin.readline
    N, P, Q = map(int, input().strip().split())
    A = list(map(int, input().strip().split()))
    B = list(map(int, input().strip().split()))

    if P == Q:
        pos = True
        for i in range(N):
            if A[i] != B[i]:
                pos = False
                break

        if pos:
            print("YES")
            for i in range(N):
                print(0, end=" ")
        else:
            print("NO")
    else:
        if P < Q:
            P, Q = Q, P
            for i in range(N):
                A[i], B[i] = B[i], A[i]

        pos = True
        answer = []
        for i in range(N):
            if A[i] == B[i]:
                answer.append(0)
            elif A[i] < B[i]:
                a = B[i] - A[i]
                b = P - Q
                if a % b == 0:
                    answer.append(a // b)
                else:
                    pos = False
                    break
            else:
                pos = False
                break
        if pos:
            print("YES")
            print(*answer)
        else:
            print("NO")

