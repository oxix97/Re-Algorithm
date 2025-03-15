import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N, P = map(int, input().split())
    nums = []
    n = N
    while True:
        n = (n * N) % P

        if n in nums:
            start = nums.index(n)
            circle = len(nums) - start
            print(circle)
            break

        nums.append(n)
