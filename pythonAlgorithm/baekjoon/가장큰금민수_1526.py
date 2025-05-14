def main():
    N = int(input())
    for i in range(N, 3, -1):
        a = list(map(int, str(i)))
        a = [i for i in a if i != 4 and i != 7]
        if len(a) == 0:
            print(i)
            break

if __name__ == '__main__':
    main()
