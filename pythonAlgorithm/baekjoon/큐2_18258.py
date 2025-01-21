import sys
from collections import deque

if __name__ == '__main__':
    N = int(input())
    queue = deque([])
    for _ in range(N):
        lst = sys.stdin.readline().split()
        size = len(queue)
        if lst[0]=="push":
            queue.append(lst[1])
        elif lst[0]=="pop":
            if size==0: print(-1)
            else: print(queue.popleft())
        elif lst[0]=="size":
            print(size)
        elif lst[0]=="empty":
            if size==0: print(1)
            else: print(0)
        elif lst[0]=="front":
            if size==0: print(-1)
            else: print(queue[0])
        elif lst[0]=="back":
            if size==0: print(-1)
            else: print(queue[-1])
