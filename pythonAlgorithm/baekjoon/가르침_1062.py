import sys
from itertools import combinations


def solve(words, teach):
    count = 0
    for word in words:
        can_read = True
        for char in word:
            if not teach[ord(char) - ord('a')]:
                can_read = False
                break
        if can_read:
            count += 1
    return count


if __name__ == '__main__':
    input = sys.stdin.readline
    N, K = map(int, input().split())

    # 단어 입력 받기
    words = []
    for _ in range(N):
        word = input().strip()
        words.append(word[4:-4])

    if K < 5:
        print(0)
        exit(0)

    essential = ['a', 'c', 'i', 'n', 't']

    # 가르칠 수 있는 알파벳 후보
    other = []
    for char in range(ord('a'), ord('z') + 1):
        if chr(char) not in essential:
            other.append(chr(char))

    max_count = 0

    # K-5개의 추가 글자를 선택하는 모든 조합
    for comb in combinations(other, K - 5):
        teach = [False] * 26

        for char in essential:
            teach[ord(char) - ord('a')] = True

        for char in comb:
            teach[ord(char) - ord('a')] = True

        # 읽을 수 있는 단어 수 계산
        count = solve(words, teach)
        max_count = max(max_count, count)

    print(max_count)
