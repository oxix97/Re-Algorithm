def solution(s):
    answer = len(s)

    for i in range(1, len(s) // 2 + 1):
        result = ""
        prev = s[:i]
        count = 1

        for j in range(i, len(s), i):
            now = s[j:j + i]

            if prev == now:
                count += 1
            else:
                if count >= 2:
                    result += str(count) + prev
                else:
                    result += prev
                prev = now
                count = 1

        if count >= 2:
            result += str(count) + prev
        else:
            result += prev

        answer = min(answer, len(result))

    return answer


if __name__ == '__main__':
    in_outs = [
        ("aabbaccc", 7),
        ("ababcdcdababcdcd", 9),
        ("abcabcdede", 8),
        ("abcabcabcabcdededededede", 14),
        ("xababcdcdababcdcd", 17)
    ]

    for input, actual in in_outs:
        expect = solution(input)
        if expect != actual:
            print(f"expect : {expect}, actual : {actual}")
