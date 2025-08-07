N = int(input())
n2 = 0
n5 = 0
for i in range(1, N + 1):
    while i % 2 == 0:
        i //= 2
        n2 += 1
    while i % 5 == 0:
        i //= 5
        n5 += 1

print(min(n2,n5))
