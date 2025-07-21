import sys

input = sys.stdin.readline
N, L = map(int, input().split())

time = 0
pos = 0

for _ in range(N):
    D, R, G = map(int, input().split())

    # 다음 신호등까지 이동하는 시간을 더함
    time += (D - pos)
    pos = D

    # 현재 시간이 주기 중 어디에 해당하는지 계산
    cycle = R + G
    time_in_cycle = time % cycle

    # 빨간 불 대기
    if time_in_cycle < R:
        wait_time = R - time_in_cycle
        time += wait_time

# 마지막 신호등 이후 거리
time += (L - pos)

print(time)
