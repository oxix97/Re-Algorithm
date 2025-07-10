import sys


def check_word(word):
    stack = []
    for w in word:
        if stack and stack[-1] == w:
            stack.pop()
        else:
            stack.append(w)

    return len(stack) == 0


input = sys.stdin.readline
N = int(input())
words = [input().strip() for _ in range(N)]
answer = 0
for word in words:
    if check_word(word):
        answer += 1

print(answer)
