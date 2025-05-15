import sys
from collections import defaultdict

def main():
    input = sys.stdin.readline

    N, K = map(int, input().split())
    arr = list(map(int, input().split()))

    prefix_sum = 0
    count = 0
    counter = defaultdict(int)
    counter[0] = 1  # 누적합이 K와 같은 경우를 위해 초기값 1로 설정

    for num in arr:
        prefix_sum += num
        count += counter[prefix_sum - K]
        counter[prefix_sum] += 1

    print(count)


if __name__ == '__main__':
    main()
