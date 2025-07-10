import sys
from collections import deque


def main():
    input = sys.stdin.readline
    T = int(input())

    for _ in range(T):
        left, right = deque(), deque()
        input_text = [s for s in input().strip()]
        for text in input_text:
            if text == '<':
                if left:
                    right.appendleft(left.pop())
            elif text == '>':
                if right:
                    left.append(right.popleft())
            elif text == '-':
                if left:
                    left.pop()
            else:
                left.append(text)

        print(''.join(left + right))

if __name__ == '__main__':
    main()
