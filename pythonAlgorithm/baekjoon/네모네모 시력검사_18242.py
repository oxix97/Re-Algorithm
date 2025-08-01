import sys

input = sys.stdin.readline
N, M = map(int, input().split())
A = []
for _ in range(N):
    s = list(input().strip())
    if '#' not in s: continue
    A.append(s)

left, right = 0, M - 1
while A[0][left] != '#':
    left += 1
while A[0][right] != '#':
    right -= 1
height = len(A)

a = A[0][left:right + 1].count('#')
b = A[height - 1][left:right + 1].count('#')
c = [A[i][left] for i in range(height)].count('#')
d = [A[i][right] for i in range(height)].count('#')

if a < b:
    print('UP')
if a > b:
    print('DOWN')
if c < d:
    print('LEFT')
if c > d:
    print('RIGHT')
