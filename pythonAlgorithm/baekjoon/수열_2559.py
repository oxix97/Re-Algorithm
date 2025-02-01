import sys

def main():
    input = sys.stdin.readline
    N,K = map(int,(input().split()))
    nums = list(map(int,(input().split())))
    pnums = []
    tmp = 0
    for i in range(K):
        tmp += nums[i]
    pnums.append(tmp)
    for i in range(1,N - K + 1):
        pnums.append(pnums[i - 1] - nums[i - 1] + nums[i + K - 1])
    answer = max(pnums)
    print(answer)

if __name__ == '__main__':
    main()