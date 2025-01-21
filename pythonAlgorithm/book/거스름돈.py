def solution(n):
    coin_types = [500,100,50,10]
    count = 0
    for coin in coin_types:
        count += n // coin
        n%=coin
    return count

if __name__ == '__main__':
    n = 1260
    answer = solution(n)
    print(answer)