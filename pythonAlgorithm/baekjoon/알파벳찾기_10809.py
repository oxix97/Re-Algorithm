if __name__ == '__main__':
    words = input().strip()
    answer = [-1] * 26
    for i in range(len(words)):
        idx = ord(words[i]) - ord('a')
        if answer[idx] == -1:
            answer[idx] = i

    for i in range(26):
        print(answer[i], end=" ")






