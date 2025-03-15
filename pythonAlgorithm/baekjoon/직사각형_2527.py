import sys

if __name__ == '__main__':
    def calculate(r1, r2):
        # r1: [x1, y1, x2, y2], r2: [x3, y3, x4, y4]
        # 두 직사각형이 겹치지 않는 경우 (d)
        if r1[2] < r2[0] or r2[2] < r1[0] or r1[3] < r2[1] or r2[3] < r1[1]:
            return 'd'

        # 점에서 만나는 경우 (c)
        if (r1[0] == r2[2] and r1[1] == r2[3]) or \
                (r1[0] == r2[2] and r1[3] == r2[1]) or \
                (r1[2] == r2[0] and r1[1] == r2[3]) or \
                (r1[2] == r2[0] and r1[3] == r2[1]):
            return 'c'

        # 선분에서 만나는 경우 (b)
        if r1[0] == r2[2] or r1[2] == r2[0] or r1[1] == r2[3] or r1[3] == r2[1]:
            return 'b'

        # 그 외 면적으로 겹치는 경우 (a)
        return 'a'


    input = sys.stdin.readline
    result = []
    for _ in range(4):
        A = list(map(int, input().split()))
        r1 = [A[0], A[1], A[2], A[3]]
        r2 = [A[4], A[5], A[6], A[7]]
        result.append(calculate(r1, r2))
    for answer in result:
        print(answer)