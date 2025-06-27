def solution(g, p, arr):
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    parent = [i for i in range(g + 1)]
    count = 0

    for a in arr:
        pos = find(a)
        if pos == 0:
            break
        parent[pos] = find(pos - 1)
        count += 1

    return count


if __name__ == '__main__':
    inputs = [
        (4, 3, [4, 1, 1], 2),
        (4, 6, [2, 2, 3, 3, 4, 4], 3)
    ]
    for G, P, A, actual in inputs:
        expect = solution(G, P, A)
        if expect != actual:
            print(f'expect: {expect}, actual: {actual}')
