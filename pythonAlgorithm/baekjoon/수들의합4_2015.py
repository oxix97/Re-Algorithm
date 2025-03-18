import sys
from itertools import combinations


def main():
    input = sys.stdin.readline
    N, K = map(int, input().split())
    A = list(map(int, input().split()))

    psum = [0] * N
    psum[0] = A[0]
    for i in range(1, N):
        psum[i] = psum[i - 1] + A[i]

    answer = 0
    count = {}
    for i in range(N):
        target = psum[i] - K
        print(f"target : {target}")
        if target == 0:
            answer += 1
        if target in count:
            answer += count[target]
        if psum[i] not in count:
            count[psum[i]] = 0
        count[psum[i]] += 1
        print(f"count : {count}")
        print(f"answer : {answer}")
        print("--------------------------------------")

    print(answer)


if __name__ == '__main__':
    main()
