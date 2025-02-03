import sys
from queue import PriorityQueue


def main():
    input = sys.stdin.readline
    N = int(input())
    pq = PriorityQueue()
    for _ in range(N):
        n = int(input())
        pq.put(n)

    answer = 0
    while pq.qsize() != 1:
        a = pq.get()
        b = pq.get()
        c = a + b
        answer += c
        pq.put(c)

    print(answer)

if __name__ == '__main__':
    main()
