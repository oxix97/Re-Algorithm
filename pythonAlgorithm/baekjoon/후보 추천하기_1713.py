import sys

input = sys.stdin.readline

N = int(input())
C = int(input())
numbers = list(map(int, input().split()))
recommend = [0] * (C + 1)
time = [0] * (C + 1)
p = []
for num in numbers:
    # 추천 회수 증가
    recommend[num] += 1

    # 사진 틀에 없는 경우
    if num not in p:
        if len(p) < N:
            p.append(num)
        else:
            remove_idx = -1
            min_rec = 1001
            t = 0

            for i in range(N):
                student = p[i]
                # 추천 수가 더 많은 경우
                if recommend[student] < min_rec:
                    min_rec = recommend[student]
                    t = time[student]
                    remove_idx = i
                # 추천 수가 동일한 경우 시간이 더 많은 학생을 제거
                elif recommend[student] == min_rec and t < time[student]:
                    t = time[student]
                    remove_idx = i

            # 제거 할 학생이 있는 경우 교체
            if remove_idx != -1:
                recommend[p[remove_idx]] = 0
                time[p[remove_idx]] = 0
                p[remove_idx] = num

    # 앨범에 게시 된 시간 증가
    for idx in p:
        time[idx] += 1
p.sort()
print(*p)
