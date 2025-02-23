import sys
from itertools import combinations


def calculate(graph, team):
    point = 0
    for p1 in team:
        for p2 in team:
            point += graph[p1][p2]
    return point


def main():
    input = sys.stdin.readline
    N = int(input())
    graph = [list(map(int, input().split())) for _ in range(N)]
    members = set([i for i in range(N)])
    min_value = 100
    for team1 in combinations(members, len(members) // 2):
        team2 = members - set(team1)
        point = calculate(graph, team1) - calculate(graph, team2)
        min_value = min(min_value, abs(point))
        if min_value == 0:
            print(0)
            exit(0)

    print(min_value)


if __name__ == '__main__':
    main()
