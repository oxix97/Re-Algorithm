import sys

if __name__ == '__main__':
    input = sys.stdin.readline
    max_value = 0
    now = 0
    for i in range(10):
        a, b = map(int, input().split())
        now -= a
        now += b
        max_value = max(max_value, now)
    print(max_value)
