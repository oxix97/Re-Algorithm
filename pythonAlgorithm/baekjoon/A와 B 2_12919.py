S = input()
T = input()


def recursion(t):
    if len(t) == len(S):
        return t == S

    if t[-1] == 'A' and recursion(t[:-1]) == 1:
        return 1
    if t[0] == 'B' and recursion(t[1:][::-1]) == 1:
        return 1

    return 0


answer = recursion(T)
print(answer)
