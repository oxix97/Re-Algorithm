from bisect import bisect_left, bisect_right


def solution(N, X, arr):
    left = bisect_left(arr, X)
    right = bisect_right(arr, X)
    count = right - left
    return -1 if count == 0 else count


if __name__ == '__main__':
    probs = [
        (7, 2, [1, 1, 2, 2, 2, 2, 3], 4),
        (7, 4, [1, 1, 2, 2, 2, 2, 3], -1)
    ]
    for n, x, arr, actual in probs:
        expect = solution(n, x, arr)
        if expect != actual:
            print(f"expect : {expect}, actual : {actual}")
