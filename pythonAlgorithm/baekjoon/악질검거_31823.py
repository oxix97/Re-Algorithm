import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N, M = map(int, input().split())
    answer = []
    store = set()
    for i in range(N):
        tmp = list(map(str, input().strip().split()))
        max_cnt = 0
        cnt = 0
        for i in range(M):
            if tmp[i] == '.':
                cnt += 1
            else:
                max_cnt = max(max_cnt, cnt)
                cnt = 0
        if max_cnt < cnt:
            max_cnt, cnt = cnt, max_cnt
        answer.append((max_cnt, tmp[-1]))
        store.add(max_cnt)
    print(len(store))
    for item in answer:
        print(*item)
