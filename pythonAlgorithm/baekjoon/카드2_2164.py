import sys
from collections import deque

if __name__ == '__main__':
    N = int(input())
    q = deque(list(range(1, N + 1)))

    while len(q) != 1:
        # 제일 위에 있는 카드를 버림
        q.popleft()

        # 그다음위에 있는 카드를 제일 아래로 옮김
        tmp = q[0]
        q.append(tmp)
        q.popleft()

    print(q.popleft())