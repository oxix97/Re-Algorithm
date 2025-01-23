import sys

def main():
    input = sys.stdin.readline
    T = int(input().strip())
    for _ in range(T):
        N = int(input().strip())
        arr = []
        for _ in range(N):
            a, b = map(int, input().strip().split())
            arr.append((a, b))

        arr.sort()
        answer = 0
        rank = 100_001
        for i in range(N):
            if arr[i][1] < rank:
                answer += 1
                rank = arr[i][1]
        print(answer)

if __name__ == '__main__':
    main()