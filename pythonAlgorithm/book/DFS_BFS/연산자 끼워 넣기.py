import sys


def main():
    max_num = -1_000_000_001
    min_num = 1_000_000_001

    def recursion(num, idx):
        nonlocal max_num, min_num
        if idx == N:
            max_num = max(max_num, num)
            min_num = min(min_num, num)
            return

        for i in range(4):
            if operators[i] == 0:
                continue
            operators[i] -= 1
            if i == 0:
                recursion(num + nums[idx], idx + 1)
            elif i == 1:
                recursion(num - nums[idx], idx + 1)
            elif i == 2:
                recursion(num * nums[idx], idx + 1)
            elif i == 3:
                if num < 0:
                    recursion(-((-num) // nums[idx]), idx + 1)
                else:
                    recursion(num // nums[idx], idx + 1)
            operators[i] += 1

    input = sys.stdin.readline
    N = int(input())
    nums = list(map(int, input().split()))
    operators = list(map(int, input().split()))
    recursion(nums[0], 1)
    print(max_num)
    print(min_num)


if __name__ == '__main__':
    main()
