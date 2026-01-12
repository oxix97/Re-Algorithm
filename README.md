# 📘 백준 알고리즘 풀이 (BOJ)

백준 온라인 저지(BOJ) 알고리즘 문제 풀이 기록입니다.
문제 유형별로 분류하여 정리하고 있습니다.

[![Solved.ac Profile](http://mazassumn.aaaaa.com/api/v2/generate_badge?boj=oxix97)](https://solved.ac/oxix97)

---

## 📚 목차
1. [동적 계획법 (DP)](#-dp-dynamic-programming)
    - [Palindrome](#-palindrome-dp--two-pointers)
2. [그래프 (Graph)](#-graph)
    - [Union-Find](#-union-find)
3. 수학
    - 정수론
4. 탐색
   - 이진 탐색
   - 투 포인터
---

## 1. DP (Dynamic Programming)

| 번호 | 제목 | 난이도 | 풀이 코드 | 비고 (핵심 로직) |
| :---: | :---: | :---: | :---: | :--- |
| 17404 | [RGB거리 2](https://www.acmicpc.net/problem/17404) | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_17404.java) | 원형 큐 개념, 첫 집 색깔 고정 |

### 1-1. Palindrome (DP / Two Pointers)

|  번호   |                               제목                               |                                      난이도                                      |                                                 풀이 코드                                                 | 비고 (핵심 로직)          |
|:-----:|:--------------------------------------------------------------:|:-----------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------:|:--------------------|
| 2342  | [Dance Dance Revolution](https://www.acmicpc.net/problem/2342) | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_2342.java)  | DP (3차원 배열)         |
| 10942 |         [팰린드롬?](https://www.acmicpc.net/problem/10942)         | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV  | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_10942.java) | DP (S~E가 팰린드롬인지 기록) |
| 17609 |          [회문](https://www.acmicpc.net/problem/17609)           |  <img src="https://static.solved.ac/tier_small/11.svg" height="14px"> Gold V  | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/dp/BOJ_17609.java) | 투 포인터, 유사회문 판별      |

---

## 2. Graph

### 2-1. Union-Find

| 번호 | 제목 | 난이도 | 풀이 코드 | 비고 (핵심 로직) |
| :---: | :---: | :---: | :---: | :--- |
| 20040 | [사이클 게임](https://www.acmicpc.net/problem/20040) | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/graph/BOJ_20040.java) | 사이클 발생 시점 찾기 (Union-Find) |


---
## 3. Math

### 3-1. Prime Number

|  번호   |                        제목                         |                                      난이도                                      |                                                  풀이 코드                                                  | 비고 (핵심 로직) |
|:-----:|:-------------------------------------------------:|:-----------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------:|:-----------|
| 1644  |  [소수의 연속합](https://www.acmicpc.net/problem/1644)  | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/math/BOJ_1644.java)  | 정수론, 투포인터  |
| 27172 | [수 나누기 게임](https://www.acmicpc.net/problem/27172) | <img src="https://static.solved.ac/tier_small/12.svg" height="14px"> Gold IV  | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/math/BOJ_27172.java) | 정수론        |

---

## 4. Search

### 4-1. Binary Search

|  번호  |                        제목                        |                                      난이도                                      |                                                풀이 코드                                                 | 비고 (핵심 로직) |
|:----:|:------------------------------------------------:|:-----------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------:|:-----------|
| 2143 | [두 배열의 합](https://www.acmicpc.net/problem/2143) | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/search/BOJ_2143.java) | 누적합, 이진 탐색 |

### 4-2. Two Pointer

|  번호  |                      제목                      |                                      난이도                                      |                                                  풀이 코드                                                   | 비고 (핵심 로직) |
|:----:|:--------------------------------------------:|:-----------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------:|:-----------|
| 2473 | [세 용액](https://www.acmicpc.net/problem/2473) | <img src="https://static.solved.ac/tier_small/13.svg" height="14px"> Gold III | [Java](https://github.com/oxix97/Re-Algorithm/tree/main/javaAlgorithm/src/baekjoon/search/BOJ_2473.java) | 투 포인터      |