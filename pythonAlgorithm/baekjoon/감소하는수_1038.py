from itertools import combinations

def main():
    N = int(input())
    answer = []
    nums = [i for i in range(10)]
    for i in range(1, 11):
        tmp = []
        for comb in combinations(nums,i):
            c  = list(comb)
            c.reverse()
            n = int(''.join(map(str,c)))
            tmp.append(n)
        tmp.sort()
        answer.extend(tmp)

    if N >= len(answer):
        print(-1)
    else:
        print(answer[N])


if __name__ == '__main__':
    main()
