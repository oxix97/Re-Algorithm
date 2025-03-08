import sys

# N : 크래인의 개수, M : 박스의 수
# 최소시간 구하기, 모든 박스 못옮기면 -1
# 모든 크레인은 동시에 움직인다.

if __name__ == '__main__':
    # 1. 입력을 받는다.
    input = sys.stdin.readline
    N = int(input())
    C = list(map(int, input().split()))
    M = int(input())
    B = list(map(int, input().split()))
    # 2. 배열 모두 정렬
    C.sort(reverse=True)
    B.sort(reverse=True)
    # 3 - 1. 못 옮기는거 있는지 검수 ->박스 무게가 크레인 모두 큰 경우
    if C[0] < B[0]:
        print(-1)
        exit(0)

    # 3 - 2. 크레인 수 만큼 박스 수 제거
    time = 0
    while len(B) > 0:
        for c in C:
            # 3 - 3. 남은 크레인 중 박스를 옮길만한 크레인이 없으면 종료
            if len(B) > 0 and c < B[-1]:
                break
            for b in B:
                if c >= b:
                    B.remove(b)
                    break
        time += 1

    print(time)
