if __name__ == '__main__':
    N = int(input())
    numbers = input().strip()
    answer = 0
    for num in numbers:
        answer += int(num)
    print(answer)