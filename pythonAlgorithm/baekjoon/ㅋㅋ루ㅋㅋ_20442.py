def main():
    S = input()
    k_count = 0
    r_count = 0

    for i in range(len(S)):
        if S[i] == 'K': k_count += 1
        if S[i] == 'R': r_count += 1

    start = -1
    end = len(S)
    max_length = 0
    for i in range(k_count // 2 + 1):
        if r_count == 0: break

        max_length = max(max_length, 2 * i + r_count)

        start += 1
        end -= 1
        while start < end and S[start] != 'K':
            start += 1
            r_count -= 1
        while start < end and S[end] != 'K':
            end -= 1
            r_count -= 1

    print(max_length)

if __name__ == '__main__':
    main()
