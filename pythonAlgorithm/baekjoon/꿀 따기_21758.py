import sys


if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    points = list(map(int, input().split()))
    psum = [0] * N
    psum[0] = points[0]

    # 1.꿀통이 벌 사이에 있는 경우
    for i in range(1, N):
        psum[i] = psum[i - 1] + points[i]
    answer = psum[N - 2] - psum[0] + max(points[1:-1])

    # 2. 꿀통이 맨 오른쪽에 있는 경우
    for i in range(1, N - 1):
        a = psum[N - 1] - psum[0] - points[i]
        b = psum[N - 1] - psum[i]
        answer = max(answer, a + b)

    # 3. 꿀통이 맨 왼쪽에 있는 경우
    for i in range(1, N - 1):
        a = psum[N - 2] - points[i]
        b = psum[i - 1]
        answer = max(answer, a + b)

    print(answer)
