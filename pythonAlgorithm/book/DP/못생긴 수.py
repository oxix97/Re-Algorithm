import heapq


def solution(N):
    visited = {1}
    q = [1]
    dp = []

    while q:
        now = heapq.heappop(q)
        dp.append(now)

        for n in [2, 3, 5]:
            next = now * n
            if next <= 1000 and next not in visited:
                visited.add(next)
                heapq.heappush(q, next)

    return dp[N - 1]


if __name__ == '__main__':
    inputs = [(10, 12), (4, 4)]
    for input, actual in inputs:
        expect = solution(input)
        if expect != actual:
            print(f"expect : {expect}, actual: {actual}")
