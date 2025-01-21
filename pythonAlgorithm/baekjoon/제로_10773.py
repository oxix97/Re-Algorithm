if __name__ == '__main__':
    K = int(input())
    stack = []
    for _ in range(K):
        n = int(input())
        if n == 0:
            stack.pop()
        else:
            stack.append(n)
    answer = 0
    for n in stack:
        answer += n
    print(answer)