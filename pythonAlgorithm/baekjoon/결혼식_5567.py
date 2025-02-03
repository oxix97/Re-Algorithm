import sys
from collections import defaultdict


def main():
    input = sys.stdin.readline
    n = int(input())
    m = int(input())
    graph = defaultdict(list)
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    friends1 = set(graph[1])
    if len(friends1) == 0:
        print(0)
        return

    friends2 = set()
    for f1 in friends1:
        for f2 in graph[f1]:
            friends2.add(f2)

    result = set(list(friends1) + list(friends2))
    answer = len(result)
    print(answer - 1)

if __name__ == '__main__':
    main()
