import sys
from collections import defaultdict

def main():
    input = sys.stdin.readline
    n = int(input())
    m = int(input())
    graph = defaultdict(list)

    for _ in range(m):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)

    visited = set()
    dfs(graph,1,visited)
    print(len(visited) - 1)

def dfs(graph, node, visited):
    if node not in visited:
        visited.add(node)
        for item in graph[node]:
            dfs(graph, item, visited)

if __name__ == '__main__':
    main()
