
def main():
    A = list(input())
    bomb = input()
    stack = []
    bomb_length = len(bomb)
    for i in range(len(A)):
        stack.append(A[i])
        word = ''.join(stack[-bomb_length:])
        if len(stack) >= bomb_length:
            if word == bomb:
                for _ in range(bomb_length): stack.pop()

    if len(stack) == 0:
        print('FRULA')
    else:
        print(''.join(stack))

if __name__ == '__main__':
    main()