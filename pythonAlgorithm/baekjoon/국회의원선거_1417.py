import sys
from queue import PriorityQueue


def main():
    input = sys.stdin.readline
    N = int(input())
    if N == 1:
        print(0)
        return

    arr = [0] * N
    for i in range(N):
        arr[i] = int(input())

    pq = PriorityQueue()
    for i in range(1, N):
        pq.put(-arr[i])

    answer = 0
    while True:
        max_value = -pq.get()
        if max_value < arr[0]: break
        max_value -= 1
        arr[0] += 1
        pq.put(-max_value)
        answer += 1

    print(answer)


if __name__ == '__main__':
    main()
