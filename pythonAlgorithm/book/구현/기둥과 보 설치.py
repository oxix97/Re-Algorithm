def solution(n, build_frame):
    def can_build():
        safe = True
        for x, y, a in structures:
            if a == 0:
                if y == 0 or (x, y - 1, 0) in structures or (x - 1, y, 1) in structures or (x, y, 1) in structures:
                    continue
                safe = False
                break

            if a == 1:
                if (x, y - 1, 0) in structures or (x + 1, y - 1, 0) in structures or \
                        ((x - 1, y, 1) in structures and (x + 1, y, 1) in structures):
                    continue
                safe = False
                break
        return safe


    structures = []
    for x, y, a, b in build_frame:
        if b == 1:  # 설치
            structures.append((x, y, a))
            if not can_build():
                structures.remove((x, y, a))
        if b == 0:  # 삭제
            if (x, y, a) in structures:
                structures.remove((x, y, a))
                if not can_build():
                    structures.append((x, y, a))  # 삭제 취소
    structures.sort()
    return structures


if __name__ == '__main__':
    n = 5
    build_frames = [
        [[1, 0, 0, 1], [1, 1, 1, 1], [2, 1, 0, 1], [2, 2, 1, 1], [5, 0, 0, 1], [5, 1, 0, 1], [4, 2, 1, 1],
         [3, 2, 1, 1]],
        [[0, 0, 0, 1], [2, 0, 0, 1], [4, 0, 0, 1], [0, 1, 1, 1], [1, 1, 1, 1], [2, 1, 1, 1], [3, 1, 1, 1], [2, 0, 0, 0],
         [1, 1, 1, 0], [2, 2, 0, 1]]
    ]
    for build_frame in build_frames:
        expect = solution(n, build_frame)
        print(expect)
