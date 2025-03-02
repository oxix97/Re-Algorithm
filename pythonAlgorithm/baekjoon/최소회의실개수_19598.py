import sys
import heapq

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    mettings = []
    for i in range(N):
        a, b = map(int, input().split())
        mettings.append((a, b))

    mettings.sort()

    room = []
    for start, end in mettings:
        if room and room[0] <= start:
            heapq.heappop(room)
        heapq.heappush(room, end)

    print(len(room))
