A, B, C = map(int, input().split())

if B >= C:
    print(-1)
else:
    margin = C - B
    answer = 1 + A // margin
    print(answer)
