import sys

def main():
    T = int(input())
    for _ in range(T):
        N = int(input())
        arr = []
        for _ in range(N):
            a,b = map(int,input().split())
            arr.append((a,b))

        arr.sort()

        answer = 1
        min = arr[0][1]
        for i in range(1,N):
            if arr[i][1] < min:
                answer+=1
                min = arr[i][1]

        print(answer)







if __name__ == '__main__':
    main()