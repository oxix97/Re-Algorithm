# 시간초과
def main():
    A = []
    i = 1
    while len(A) <= 1_000_000:
        visited = [False] * 10
        repeatable = False
        tmp = i
        while tmp > 0:
            if visited[tmp % 10]:
                repeatable = True
                break
            visited[tmp % 10] = True
            tmp //= 10
        if not repeatable:
            A.append(i)
        i += 1

    while True:
        N = int(input())
        if N == 0:
            break

        print(A[N - 1])

if __name__ == '__main__':
    main()
