import sys

input = sys.stdin.readline
N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
visited = [False] * N
answer = 100


def calculate():
    team1 = 0
    team2 = 0
    for i in range(N):
        for j in range(i + 1, N):
            if visited[i] and visited[j]:
                team1 += (graph[i][j] + graph[j][i])
            elif (not visited[i]) and (not visited[j]):
                team2 += (graph[i][j] + graph[j][i])
    return abs(team1 - team2)


def dfs(player, cnt):
    if cnt == N // 2:
        global answer
        answer = min(answer, calculate())
        if answer == 0:
            print(0)
            exit(0)
        return

    for i in range(player, N):
        if visited[i]: continue
        visited[i] = True
        dfs(i + 1, cnt + 1)
        visited[i] = False



if __name__ == '__main__':
    dfs(0, 0)
    print(answer)
