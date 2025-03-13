import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N, Q = map(int, input().split())
    S = list(input().strip())
    for i in range(Q):
        cmd, l, r = map(int, input().split())
        l -= 1
        r -= 1
        if cmd == 1:
            cnt = 1
            target = S[l]
            for i in range(l, r + 1):
                if target != S[i]:
                    target = S[i]
                    cnt += 1
            print(cnt)
        else:
            for i in range(l, r + 1):
                if S[i] == 'Z':
                    S[i] = 'A'
                else:
                    S[i] = chr(ord(S[i]) + 1)
