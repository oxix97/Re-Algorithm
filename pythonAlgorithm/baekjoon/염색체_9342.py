import sys


def main():
    input = sys.stdin.readline
    N = int(input())
    line = {'A', 'B', 'C', 'D', 'E', 'F'}
    for _ in range(N):
        word = input().strip()

        if len(word) < 3:
            print("Good")
            continue

        if word[0] != 'A':
            if word[0] not in line:
                print("Good")
                continue
            word = word[1:]
        if word[-1] != 'C':
            if word[-1] not in line:
                print("Good")
                continue
            word = word[:-1]

        answer = ""
        for i in range(len(word)):
            if i == 0 or word[i - 1] != word[i]:
                answer += word[i]
        if answer == "AFC":
            print("Infected!")
        else:
            print("Good")



if __name__ == '__main__':
    main()
