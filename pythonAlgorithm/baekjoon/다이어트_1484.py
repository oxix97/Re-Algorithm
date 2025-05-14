def main():
    G = int(input())
    num = [i for i in range(1, 100_001)]
    left = 0
    right = 1
    answer = []
    while left < right:
        while num[right] ** 2 - num[left] ** 2 <= G and right < 100_001:
            if num[right] ** 2 - num[left] ** 2 == G:
                answer.append(num[right])
            right += 1
        left += 1

    if len(answer) == 0:
        print(-1)
    else:
        for i in answer:
            print(i)

if __name__ == '__main__':
    main()
