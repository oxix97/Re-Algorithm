from collections import deque


def solution(board):
    def next_position(pos1, pos2):
        r1, c1 = pos1
        r2, c2 = pos2

        next_pos = []
        for dr, dc in D:
            nr1, nc1 = r1 + dr, c1 + dc
            nr2, nc2 = r2 + dr, c2 + dc

            if 0 <= nr1 < N and 0 <= nc1 < N and 0 <= nr2 < N and 0 <= nc2 < N:
                if board[nr1][nc1] == 0 and board[nr2][nc2] == 0:
                    next_pos.append(((nr1, nc1), (nr2, nc2)))

        # 2. 회전 이동
        # 로봇이 가로로 놓인 경우
        if r1 == r2:
            # 위쪽으로 회전 (축이 왼쪽점, 오른쪽점)
            if r1 > 0 and board[r1 - 1][c1] == 0 and board[r1 - 1][c2] == 0:
                next_pos.append(tuple(sorted(((r1, c1), (r1 - 1, c1)))))  # 왼쪽점 축
                next_pos.append(tuple(sorted(((r2, c2), (r2 - 1, c2)))))  # 오른쪽점 축
            # 아래쪽으로 회전
            if r1 < N - 1 and board[r1 + 1][c1] == 0 and board[r1 + 1][c2] == 0:
                next_pos.append(tuple(sorted(((r1, c1), (r1 + 1, c1)))))  # 왼쪽점 축
                next_pos.append(tuple(sorted(((r2, c2), (r2 + 1, c2)))))  # 오른쪽점 축

        # 로봇이 세로로 놓인 경우
        else:  # c1 == c2
            # 왼쪽으로 회전
            if c1 > 0 and board[r1][c1 - 1] == 0 and board[r2][c1 - 1] == 0:
                next_pos.append(tuple(sorted(((r1, c1), (r1, c1 - 1)))))  # 위쪽점 축
                next_pos.append(tuple(sorted(((r2, c2), (r2, c2 - 1)))))  # 아래쪽점 축
            # 오른쪽으로 회전
            if c1 < N - 1 and board[r1][c1 + 1] == 0 and board[r2][c1 + 1] == 0:
                next_pos.append(tuple(sorted(((r1, c1), (r1, c1 + 1)))))  # 위쪽점 축
                next_pos.append(tuple(sorted(((r2, c2), (r2, c2 + 1)))))  # 아래쪽점 축

        # 중복 제거 후 반환 (좌표를 정렬해서 넣었으므로 set으로 자동 처리 가능)
        return list(set(next_pos))

    N = len(board)
    goal = (N - 1, N - 1)
    q = deque([(((0, 0), (0, 1)), 0)])
    D = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    visited = {((0, 0), (0, 1))}

    while q:
        pos, cost = q.popleft()
        pos1, pos2 = pos

        if pos1 == goal or pos2 == goal:
            return cost

        for next_pos in next_position(pos1, pos2):
            if next_pos not in visited:
                visited.add(next_pos)
                q.append((next_pos, cost + 1))

    return -1


if __name__ == '__main__':
    board = [[0, 0, 0, 1, 1], [0, 0, 0, 1, 0], [0, 1, 0, 1, 1], [1, 1, 0, 0, 1], [0, 0, 0, 0, 0]]
    actual = 7
    expect = solution(board)
    if expect != actual:
        print(f"expect : {expect}, actual : {actual}")
