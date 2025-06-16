def main():
    S = input()

    letters = sorted([s for s in S if s.isalpha()])
    sum_numbers = sum([int(s) for s in S if s.isdigit()])

    result = ''.join(letters) + str(sum_numbers)
    print(result)


if __name__ == '__main__':
    main()
