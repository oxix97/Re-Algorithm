def main():
    N = list(map(int, input()))
    A = sum(N[:len(N) // 2])
    B = sum(N[len(N) // 2:])
    if A == B:
        print("LUCKY")
    else:
        print("READY")


if __name__ == '__main__':
    main()
