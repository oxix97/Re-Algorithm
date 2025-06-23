def solution(N, arr):
    left = 0
    right = N - 1
    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == mid:
            return mid
        if arr[mid] < mid:
            left = mid + 1
        else:
            right = mid - 1
    return -1


if __name__ == '__main__':
    inputs = [
        (5, [-15, -6, 1, 3, 7],3),
        (7, [-15, -4, 2, 8, 9, 13, 15],2),
        (7, [-15, -4, -3, 8, 9, 13, 15],-1)
    ]
    for n,arr,actual in inputs:
        expect = solution(n,arr)
        if expect != actual:
            print(f"expect : {expect}, actual : {actual}")
