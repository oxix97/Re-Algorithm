import sys
from collections import Counter

# 1. N,K 입력 받는다.
# 2. A 배열 입력 받는다.
# 3. 1 ~ 100,000의 등장 회수를 저장하는 배열 선언
# 4. 연속된 부분이 K이하인 경우 right += 1
# 4. 연속된 부분이 K개 초과 left -= 1
# 4. right - left + 1 길이 저장
# 5. 정답 출력

input = sys.stdin.readline
N, K = map(int, input().split())
A = list(map(int, input().split()))

if __name__ == '__main__':
    cnt = Counter()
    answer = 0
    right = 0
    for left in range(N):
        while right < N:
            if cnt[A[right]] + 1 > K:
                break
            cnt[A[right]] += 1
            right += 1
        answer = max(answer, right - left)
        cnt[A[left]] -= 1

    print(answer)
