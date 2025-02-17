def solution(name):
    cost = 0
    for alphabet in name:
        cost += min(ord(alphabet) - ord('A'), ord('Z') - ord(alphabet) + 1)

    n = len(name)
    min_move = n - 1
    for i in range(n):
        next = i + 1
        while next < n and name[next] == 'A':
            next += 1
        distance = i + n - next + min(i, n - next)
        min_move = min(min_move, distance)

    return cost + min_move