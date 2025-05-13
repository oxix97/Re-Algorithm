import sys
import math
from itertools import combinations

def main():
    input = sys.stdin.readline
    N,M = map(int,input().split())
    chicken = []
    house = []
    for i in range(N):
        tmp = list(map(int, input().split()))
        for j in range(N):
            if tmp[j] == 1:
                house.append((i + 1,j + 1))
            elif tmp[j] == 2:
                chicken.append((i + 1,j + 1))

    answer = 1e9
    for comb in combinations(chicken,M):
        total = 0
        for r1,c1 in house:
            min_dist = 1e9
            for r2, c2 in comb:
                min_dist = min(abs(r1-r2) + abs(c1-c2),min_dist)
            total += min_dist
        answer = min(answer, total)
    print(answer)







# 1. 치킨 집 배열 저장 C
# 2. 집 배열 저장 H
# 3. C에서 M개 조합
# 4. 치킨 거리 구하기 가장 최소 정답

if __name__ == '__main__':
    main()