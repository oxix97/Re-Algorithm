# 📘 백준 알고리즘 풀이 (BOJ)

백준 온라인 저지(BOJ) 알고리즘 문제 풀이 기록입니다.
문제 유형별로 분류하여 정리하고 있습니다.

---

## 📚 목차

1.동적 계획법 (DP)
- Palindrome

2.그래프
- DFS / BFS
- Union-Find

3.수학
- 정수론


4.탐색
- 이진 탐색
- 투 포인터

5.구현

---

## 1. DP (Dynamic Programming)

| 번호    | 제목                                                       | 난이도                                                                           | 핵심 로직 | 풀이 코드 | velog                                                                                                                    |
|-------|----------------------------------------------------------|-------------------------------------------------------------------------------| -- | --- |--------------------------------------------------------------------------------------------------------------------------|
| 1520  | [내리막 길](https://www.acmicpc.net/problem/1520)            | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | DFS, DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_1520.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ1520-%EB%82%B4%EB%A6%AC%EB%A7%89-%EA%B8%B8)                     |
| 1937  | [욕심쟁이 판다](https://www.acmicpc.net/problem/1937)          | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | DFS, DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_1937.java) |                                                                                                                          |
| 2133  | [욕심쟁이 판다](https://www.acmicpc.net/problem/2133)          | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold IV  | DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_2133.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ2133-%ED%83%80%EC%9D%BC-%EC%B1%84%EC%9A%B0%EA%B8%B0) |
| 2225  | [합분해](https://www.acmicpc.net/problem/2225)              | <img src="https://static.solved.ac/tier_small/11.svg" height="14px"> Gold V   | 수학, DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_2225.java) |                                                                                                                          |
| 2293  | [동전 1](https://www.acmicpc.net/problem/2293)             | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV  | DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_2293.java) |                                                                                                                          |
| 2294  | [동전 2](https://www.acmicpc.net/problem/2294)             | <img src="https://static.solved.ac/tier_small/11.svg" height="14px"> Gold V   | DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_2294.java) |                                                                                                                          |
| 2629  | [양팔저울](https://www.acmicpc.net/problem/2629)             | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | DP, DFS | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_2629.java) |                                                                                                                          |
| 9251  | [LCS](https://www.acmicpc.net/problem/9251)              | <img src="https://static.solved.ac/tier_small/11.svg" height="14px"> Gold V   | 최장 공통 부분 수열(LCS), DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_9251.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ9251-LCS)                                                       |
| 11048 | [이동하기](https://www.acmicpc.net/problem/11048)            | <img src="https://static.solved.ac/tier_small/9.svg" height="14px"> SLIVER II | DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_11048.java) |                                                                                                                          |
| 11049 | [행렬 곱셈 순서](https://www.acmicpc.net/problem/11049)        | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | 행렬, DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_11049.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ11049-%ED%96%89%EB%A0%AC-%EA%B3%B1%EC%85%88-%EC%88%9C%EC%84%9C) |
| 11053 | [가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053) | <img src="https://static.solved.ac/tier_small/9.svg" height="14px"> SLIVER II | DP, 최장 증가 부분 수열(LIS) | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_11053.java) |                                                                                                                          |
| 11055 | [가장 큰 증가하는 부분 수열](https://www.acmicpc.net/problem/11055) | <img src="https://static.solved.ac/tier_small/9.svg" height="14px"> SLIVER II | DP, 최장 증가 부분 수열(LIS) | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_11055.java) |                                                                                                                          |
| 11066 | [파일 합치기](https://www.acmicpc.net/problem/11066)          | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | 누적합, DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_11066.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ11066-%ED%8C%8C%EC%9D%BC-%ED%95%A9%EC%B9%98%EA%B8%B0)           |
| 15486 | [퇴사 2](https://www.acmicpc.net/problem/15486)            | <img src="https://static.solved.ac/tier_small/11.svg" height="14px"> Gold V   | DP | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_15486.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ15486-%ED%87%B4%EC%82%AC-2)                                     |
| 17404 | [RGB거리 2](https://www.acmicpc.net/problem/17404)         | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV  | 원형 큐 개념, 첫 집 색깔 고정 | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_17404.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ17404-RGB%EA%B1%B0%EB%A6%AC-2)                                  |

### 1-1. Palindrome (DP / Two Pointers)

| 번호 | 제목 | 난이도 | 핵심 로직 | 풀이 코드 | velog                                                                                                |
| --- | --- | --- | --- | --- |------------------------------------------------------------------------------------------------------|
| 2342 | [Dance Dance Revolution](https://www.acmicpc.net/problem/2342) | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | DP (3차원 배열) | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_2342.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ2342-Dance-Dance-Revolution)                |
| 10942 | [팰린드롬?](https://www.acmicpc.net/problem/10942) | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV | DP (S~E가 팰린드롬인지 기록) | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_10942.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ10942-%ED%8C%B0%EB%A6%B0%EB%93%9C%EB%A1%AC) |
| 17609 | [회문](https://www.acmicpc.net/problem/17609) | <img src="https://static.solved.ac/tier_small/11.svg" height="14px"> Gold V | 투 포인터, 유사회문 판별 | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_17609.java) |                                                                                                      |

---

## 2. Graph

### 2-1. DFS / BFS

| 번호 | 제목 | 난이도 | 핵심 로직 | 풀이 코드 | velog                                                                                                         |
| --- | --- | --- | --- | --- |---------------------------------------------------------------------------------------------------------------|
| 9466 | [텀 프로젝트](https://www.acmicpc.net/problem/9466) | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | 사이클 발생 시점 찾기 (DFS) | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/graph/BOJ_9466.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ9466-%ED%85%80-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8) |

### 2-2. Union-Find

| 번호 | 제목 | 난이도 | 핵심 로직 | 풀이 코드 | velog                                                                                                                   |
| --- | --- | --- | --- | --- |-------------------------------------------------------------------------------------------------------------------------|
| 20040 | [사이클 게임](https://www.acmicpc.net/problem/20040) | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV | 사이클 발생 시점 찾기 (Union-Find) | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/graph/BOJ_20040.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ20040-%EC%82%AC%EC%9D%B4%ED%81%B4-%EA%B2%8C%EC%9E%84-mwfbbq34) |

---

## 3. Math

| 번호 | 제목 | 난이도 | 핵심 로직 | 풀이 코드 | velog                                                                                                            |
| --- | --- | --- | --- | --- |------------------------------------------------------------------------------------------------------------------|
| 11444 | [피보나치 수 6 ](https://www.acmicpc.net/problem/11444) | <img src="https://static.solved.ac/tier_small/14.svg" height="14px"> Gold II | 분할정복을 이용한 거듭제곱, 선형대수학 | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/math/BOJ_11444.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ11444-%ED%94%BC%EB%B3%B4%EB%82%98%EC%B9%98-%EC%88%98-6) |

### 3-1. Prime Number

| 번호 | 제목 | 난이도 | 핵심 로직 | 풀이 코드 | velog |
| --- | --- | --- | --- | --- | --- |
| 1644 | [소수의 연속합](https://www.acmicpc.net/problem/1644) | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | 정수론, 투포인터 | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/math/BOJ_1644.java) |  |
| 27172 | [수 나누기 게임](https://www.acmicpc.net/problem/27172) | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV | 정수론 | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/math/BOJ_27172.java) |  |

---

## 4. Search

### 4-1. Binary Search

| 번호 | 제목 | 난이도 | 핵심 로직 | 풀이 코드 | velog                                                                                                          |
| --- | --- | --- | --- | --- |----------------------------------------------------------------------------------------------------------------|
| 2143 | [두 배열의 합](https://www.acmicpc.net/problem/2143) | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | 누적합, 이진 탐색 | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/search/BOJ_2143.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ2143-%EB%91%90-%EB%B0%B0%EC%97%B4%EC%9D%98-%ED%95%A9) |

### 4-2. Two Pointer

| 번호 | 제목 | 난이도 | 핵심 로직 | 풀이 코드 | velog                                                                                       |
| --- | --- | --- | --- | --- |---------------------------------------------------------------------------------------------|
| 2473 | [세 용액](https://www.acmicpc.net/problem/2473) | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | 투 포인터 | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/search/BOJ_2473.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ2473-%EC%84%B8-%EC%9A%A9%EC%95%A1) |

## 5. Implementation

| 번호 | 제목 | 난이도 | 핵심 로직 | 풀이 코드 | velog                                                                                                         |
| --- | --- | --- | --- | --- |---------------------------------------------------------------------------------------------------------------|
| 1918 | [후위 표기식](https://www.acmicpc.net/problem/1918) | <img src="https://static.solved.ac/tier_small/14.svg" height="14px"> Gold II | 스택 | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/implementation/BOJ_1918.java) | [velog](https://velog.io/@ieejo716/%EB%B0%B1%EC%A4%80-BOJ1918-%ED%9B%84%EC%9C%84-%ED%91%9C%EA%B8%B0%EC%8B%9D) |