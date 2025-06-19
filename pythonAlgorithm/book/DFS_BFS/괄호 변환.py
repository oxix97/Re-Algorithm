def solution(w):
    return recursion(w)


def check(w):
    stack = []
    for s in w:
        if s == '(':
            stack.append('(')
        else:
            if len(stack) == 0:
                return False
            stack.pop()

    return len(stack) == 0


def reverse_word(w):
    rw = ''
    for s in w:
        if s == '(':
            rw += ')'
        else:
            rw += '('
    return rw


def recursion(w):
    if w == '':
        return w

    left = 0
    right = 0
    mid = 0

    for i in range(len(w)):
        if w[i] == '(':
            left += 1
        else:
            right += 1
        if left == right:
            mid = i
            break

    u, v = w[:mid + 1], w[mid + 1:]

    if check(u):
        return u + solution(v)
    else:
        return '(' + solution(v) + ')' + reverse_word(u[1:len(u) - 1])


if __name__ == '__main__':
    prob = ["(()())()", ")(", "()))((()"]
    actual = ["(()())()", "()", "()(())()"]
    for i in range(len(prob)):
        expect = solution(prob[i])
        if expect != actual[i]:
            print(f"expect : {expect}, actual : {actual[i]}")
