import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    N = int(input())
    subject = []
    score = 0
    for i in range(N):
        cmd = list(map(int, input().split()))
        if cmd[0] == 1:
            A = cmd[1]
            T = cmd[2]
            if T == 1:
                score += A
            else:
                subject.append((A, T - 1))
        else:
            if len(subject) == 0: continue
            a, t = subject.pop()
            if t == 1:
                score += a
            else:
                subject.append((a, t - 1))
    print(score)
