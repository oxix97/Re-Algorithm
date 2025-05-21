# 시간초과
def main():
    # 반복하지 않는 수를 미리 계산하여 저장
    non_repeating_numbers = []
    num = 1

    # 100만까지의 반복하지 않는 수를 모두 계산 (충분한 양)
    while len(non_repeating_numbers) < 1000000:
        # 주어진 코드 방식을 활용하여 반복하지 않는 수인지 확인
        check = [False] * 10
        temp_num = num
        is_non_repeating = True

        while temp_num > 0:
            tmp = temp_num % 10
            if check[tmp]:
                is_non_repeating = False
                break
            check[tmp] = True
            temp_num //= 10

        # 반복하지 않는 수라면 목록에 추가
        if is_non_repeating:
            non_repeating_numbers.append(num)

        num += 1

    # 사용자 쿼리 처리
    while True:
        n = int(input())
        if n == 0:
            break
        # n번째 반복하지 않는 수 출력
        print(non_repeating_numbers[n - 1])


if __name__ == '__main__':
    main()
