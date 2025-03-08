import sys
from collections import Counter

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    sells = Counter()
    for _ in range(N):
        book = input().strip()
        sells[book] += 1
    books = sells.most_common()
    max_count = books[0][1]  # 최대 빈도 값
    answer = [book for book, count in books if count == max_count]
    answer.sort()
    print(answer[0])
