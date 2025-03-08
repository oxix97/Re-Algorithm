if __name__ == '__main__':
    N = input()
    nums = list(N)
    visited = set()

    def solution(left, right, num, history):
        if num == N and history not in visited:
            visited.add(history)

        else:
            if left > 0:
                solution(left - 1, right, nums[left - 1] + num, history + num)

            if right < len(nums) - 1:
                solution(left, right + 1, num + nums[right + 1], history + num)


    for i in range(len(nums)):
        solution(i, i, nums[i], nums[i])

    print(len(visited))
