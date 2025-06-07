import sys

def main():
    input = sys.stdin.readline
    N = int(input())
    A = []
    for _ in range(N):
        name, point = input().split()
        A.append((name,point))

    results = sorted(A,key=lambda student: student[1])
    for result in results:
        print(result[0],end=' ')



if __name__ == '__main__':
    main()