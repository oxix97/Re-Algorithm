def main():
    nums = list(input())
    answer = int(nums[0])
    for n in nums[1:]:
        current = int(n)

        if answer <= 1 or current <= 1:
            answer += current
        else:
            answer *= current

    print(answer)


if __name__ == '__main__':
    main()
