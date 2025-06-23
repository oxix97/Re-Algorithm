from collections import Counter


def solution(N, stages):
    user_stages = Counter(stages)
    total_stage = len(stages)
    failures = []
    for i in range(1, N + 1):
        if total_stage == 0 or user_stages[i] == 0:
            failure = 0
        else:
            failure = user_stages[i] / total_stage
        failures.append((failure, i))
        total_stage -= user_stages[i]

        answer = sorted(failures, key=lambda x: (-x[0], x[1]))

    return [answer[i][1] for i in range(len(answer))]


if __name__ == '__main__':
    answer = solution(5, [2, 1, 2, 6, 2, 4, 3, 3])
    print(answer)
