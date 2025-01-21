if __name__ == '__main__':
    numbers = list()
    for i in range(10):
        numbers.append(int(input()) % 42)

    number_set = set(numbers)
    print(len(number_set))
