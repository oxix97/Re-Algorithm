def main():
    S = list(input())
    a = 0
    b = 0
    for i in range(len(S) - 1):
        if S[i] == '0' and S[i] != S[i + 1]:
            a += 1
        if S[i] == '1' and S[i] != S[i + 1]:
            b += 1

    print(min(a, b))


if __name__ == '__main__':
    main()
