import sys

def main():
    input = sys.stdin.readline
    T = int(input())
    result = []

    for _ in range(T):
        pre = list(input().split())
        post = []
        for word in pre:
            arr = list(word)
            arr.reverse()
            post.append(''.join(arr))
        result.append(' '.join(post))
    for answer in result:
        print(''.join(answer))

if __name__ == '__main__':
    main()