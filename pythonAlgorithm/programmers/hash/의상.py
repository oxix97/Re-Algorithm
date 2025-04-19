from collections import defaultdict

def solution(clothes):
    answer = 1
    A = defaultdict(list)
    for value, key in clothes:
        A[key].append(value)
    for i in A.keys():
        answer *= len(A[i]) + 1

    return answer - 1