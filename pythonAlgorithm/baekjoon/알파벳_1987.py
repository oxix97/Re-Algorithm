import sys

input = sys.stdin.readline

R, C = map(int, input().split())
B = [list(input().strip()) for _ in range(R)]

D = [(1, 0), (-1, 0), (0, 1), (0, -1)]
visit = [False] * 26
answer = 0


def dfs(r, c, count):
    global answer
    answer = max(answer, count)

    if answer == 26:
        return

    for dr, dc in D:
        nr, nc = r + dr, c + dc
        if 0 <= nr < R and 0 <= nc < C:
            idx = ord(B[nr][nc]) - ord('A')
            if not visit[idx]:
                visit[idx] = True
                dfs(nr, nc, count + 1)
                visit[idx] = False


idx = ord(B[0][0]) - ord('A')
visit[idx] = True
dfs(0, 0, 1)
print(answer)
