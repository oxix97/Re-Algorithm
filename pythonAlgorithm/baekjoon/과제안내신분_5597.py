if __name__ == '__main__':
    numbers = list(range(1,31))
    for i in range(28):
        numbers.remove(int(input()))
    numbers.reverse()
    print(numbers.pop())
    print(numbers.pop())