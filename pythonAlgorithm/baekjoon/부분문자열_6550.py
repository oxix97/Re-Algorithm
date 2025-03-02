import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    while True:
        try:
            s, t = input().split()
            n = len(s)
            idx = 0
            check = True
            for i in range(len(s)):
                while idx < len(t) and t[idx] != s[i]:
                    idx += 1
                if idx < len(t):
                    idx += 1
                else:
                    check = False
                    break

            if check:
                print("Yes")
            else:
                print("No")
        except:
            break
