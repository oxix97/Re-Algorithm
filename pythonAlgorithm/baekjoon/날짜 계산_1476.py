E, S, M = map(int, input().split())

e, s, m, year = 1, 1, 1, 1

while not (e == E and s == S and m == M):
    e = 1 + e % 15
    s = 1 + s % 28
    m = 1 + m % 19
    year += 1

print(year)