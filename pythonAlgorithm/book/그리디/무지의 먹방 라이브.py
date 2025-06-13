def solution(food_times, k):
    if sum(food_times) <= k:
        return -1

    foods = [(food_times[i], i + 1) for i in range(len(food_times))]
    foods.sort()

    prev_time = 0
    length = len(food_times)

    for i, (time, idx) in enumerate(foods):
        spend = (time - prev_time) * length

        if spend <= k:
            k -= spend
            length -= 1
            prev_time = time
        else:
            k %= length
            return sorted(foods[i:], key=lambda x: x[1])[k][1]

    return sorted(foods, key=lambda x: x[1])[k % len(foods)][1]


if __name__ == '__main__':
    food_times = [3, 1, 2]
    k = 5
    answer = solution(food_times, k)
    print(answer)
