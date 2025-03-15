import sys
from collections import defaultdict

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    balls = defaultdict(list)

    # 공 크기 별로 저장
    for i in range(N):
        c, s = map(int, input().split())
        balls[s].append((c, i))

    answer = [0] * N
    total = 0
    colors = defaultdict(int)
    for i in range(1, 2001):
        # 현재 크기의 공이 없는 경우 패스
        if len(balls[i]) == 0: continue

        for c, idx in balls[i]:
            # 현재까지의 누적합에서 같은 색상의 누적합 제거
            answer[idx] = total - colors[c]

        # 전체 누적합 업데이트
        total += i * len(balls[i])

        # 각 색상별 누적합 업데이트
        for c, _ in balls[i]:
            colors[c] += i

    for i in range(N):
        print(answer[i])
