def solution(n, m, arr, plan):
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    def union(a, b):
        pa = find(a)
        pb = find(b)
        if pa < pb:
            parent[pb] = pa
        else:
            parent[pa] = pb

    parent = [i for i in range(n)]
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 1:
                union(i, j)

    result = set()
    for p in plan:
        result.add(find(p))

    return 'YES' if len(result) == 1 else 'NO'


if __name__ == '__main__':
    inputs = [
        (5, 4,
         [
             [0, 1, 0, 1, 1],
             [1, 0, 1, 1, 0],
             [0, 1, 0, 0, 0],
             [1, 1, 0, 0, 0],
             [1, 0, 0, 0, 0]
         ],
         [2, 3, 4, 3], 'YES')
    ]
    for n, m, a, b, actual in inputs:
        expect = solution(n, m, a, b)
        if expect != actual:
            print(f"expect : {expect}, actual : {actual}")
