import sys,heapq


def main():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    J = [tuple(map(int,input().split())) for _ in range(N)]
    B = [int(input()) for _ in range(K)]

    J.sort()
    B.sort()
    answer = 0

    pq = []
    idx = 0
    for i in range(K):
        while idx < N and J[idx][0] <=B[i]:
            heapq.heappush(pq,-J[idx][1])
            idx += 1

        if len(pq) > 0:
            answer += -heapq.heappop(pq)

    print(answer)

if __name__ == '__main__':
    main()
