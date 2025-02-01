import sys

def main():
    input = sys.stdin.readline
    N = int(input())
    arr = []
    for _ in range(N):
        x, y = map(int, input().split())
        arr.append((x,y))

    answer = []
    for i in range(N):
        rank = 1
        for j in range(N):
            if i==j: continue
            if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
                rank += 1
        answer.append(rank)

    print(' '.join(map(str,answer)))

if __name__ == '__main__':
    main()