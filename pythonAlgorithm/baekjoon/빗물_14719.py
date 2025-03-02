import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    H, W = map(int, input().split())
    world = [[0 for _ in range(W)] for i in range(H)]
    heights = list(map(int, input().split()))
    # 1. 블록 세우기
    for i in range(H):
        for j in range(W):
            if heights[j] > 0:
                world[i][j] = 1
                heights[j] -= 1
            else:
                world[i][j] = 0

    # 2. 빗물 채우기
    # 2-1. 양끝에 벽이 있는 경우 비어 있는 공간 매꾸기
    for i in range(H):
        left = 0
        right = W - 1
        # 2.1 왼쪽 벽
        while left < W and world[i][left] == 0:
            left += 1
        # 2.1 오른쪽 벽
        while 0 < right and world[i][right] == 0:
            right -= 1

        # 2-2. 벽 사이 공간은 모두 채우기
        for j in range(left, right):
            if world[i][j] == 0:
                world[i][j] = 2

    # 3. 빗물 총량 구하기
    total = 0
    for i in range(H):
        for j in range(W):
            if world[i][j] == 2:
                total += 1
    print(total)
