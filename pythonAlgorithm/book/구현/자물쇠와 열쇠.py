def solution(key, lock):
    def rotate_90(matrix):
        n = len(matrix)
        result = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                result[j][n - 1 - i] = matrix[i][j]
        return result

    def check(key, lock, y, x):
        # 확장된 자물쇠 배열 생성 (key 크기만큼 패딩)
        key_len = len(key)
        lock_len = len(lock)
        expanded_lock = [[0] * (lock_len + 2 * key_len) for _ in range(lock_len + 2 * key_len)]

        # 자물쇠를 확장된 배열 중앙에 배치
        for i in range(lock_len):
            for j in range(lock_len):
                expanded_lock[i + key_len][j + key_len] = lock[i][j]

        # 열쇠를 지정된 위치에 배치
        for i in range(key_len):
            for j in range(key_len):
                expanded_lock[y + i][x + j] += key[i][j]

        # 자물쇠 영역만 검사 (모든 칸이 1이어야 함)
        for i in range(key_len, key_len + lock_len):
            for j in range(key_len, key_len + lock_len):
                if expanded_lock[i][j] != 1:
                    return False

        return True

    key_len = len(key)
    lock_len = len(lock)

    for rotation in range(4):
        for y in range(lock_len + key_len):
            for x in range(lock_len + key_len):
                if check(key, lock, y, x):
                    return True

        # 다음 회전을 위해 열쇠 회전
        key = rotate_90(key)

    return False


# 테스트
if __name__ == '__main__':
    key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
    lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
    answer = solution(key, lock)
    print(answer)  # True
