N, K, A, B = map(int, input().split())

cat_leaf = [K] * N

day = 1
while True:
    die = False
    min_value = min(cat_leaf)
    idx = cat_leaf.index(min_value)

    for i in range(idx, idx + A):
        if i >= N: break
        cat_leaf[i] += B

    for i in range(N):
        cat_leaf[i] -= 1
        if cat_leaf[i] == 0:
            die = True
            break

    if die:
        break
    day += 1

print(day)
