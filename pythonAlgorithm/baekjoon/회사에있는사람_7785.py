import sys

def main():
    input = sys.stdin.readline
    N = int(input())
    company = {}
    for i in range(N):
        name, action = input().split()
        if action == 'enter':
            company[name] = 1
        else:
            del company[name]
    answer = list(company.keys())
    answer.sort(reverse=True)
    for i in answer:
        print(i)


if __name__ == '__main__':
    main()