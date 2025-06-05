def main():
    N = int(input())
    answer =  0
    for i in range(N + 1):
        for j in range(60):
            for k in range(60):
                result = str(i) + str(j) + str(k)
                if '3' in result:
                    answer += 1

    print(answer)
if __name__ == '__main__':
    main()
