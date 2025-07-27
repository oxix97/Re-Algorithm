import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline

A, B, C = map(int, input().split())
S = A + B + C

if S % 3 != 0:
    print(0)
else:
    init_state = tuple(sorted((A, B, C)))
    visit = set([init_state])
    q = deque([init_state])
    answer = 0
    while q:
        a, b, c = q.popleft()
        if a == b == c:
            answer = 1
            break

        for x, y in combinations((a, b, c), 2):
            if x == y: continue
            x, y = min(x, y), max(x, y)
            nx = x * 2
            ny = y - x
            z = S - x - y
            next_state = tuple(sorted((nx, ny, z)))

            if next_state not in visit:
                q.append(next_state)
                visit.add(next_state)

    print(answer)
