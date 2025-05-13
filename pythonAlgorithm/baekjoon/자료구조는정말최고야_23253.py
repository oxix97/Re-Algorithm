import sys

def main():
    input = sys.stdin.readline
    N,M = map(int,input().split())
    answer = "Yes"
    for _ in range(M):
        n = int(input())
        tmp = list(map(int, input().split()))
        for i in range(1,n):
            if tmp[i - 1] < tmp[i]:
                answer = "No"
                break
    print(answer)


if __name__ == '__main__':
    main()