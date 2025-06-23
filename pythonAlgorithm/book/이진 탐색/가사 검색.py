from collections import defaultdict
from bisect import bisect_left, bisect_right


def solution(words, queries):
    answer = []
    sorted_words = defaultdict(list)
    reverse_words = defaultdict(list)
    for word in words:
        sorted_words[len(word)].append(word)
        reverse_words[len(word)].append(word[::-1])
    for key in sorted_words:
        sorted_words[key].sort()
        reverse_words[key].sort()

    for query in queries:
        if len(query) not in sorted_words:
            answer.append(0)
            continue
        if query.startswith('?') and query.endswith('?'):
            answer.append(len(sorted_words[len(query)]))
            continue
        if query.startswith('?'):
            target_list = reverse_words[len(query)]
            search_query = query[::-1]
        else:
            target_list = sorted_words[len(query)]
            search_query = query

        lower = search_query.replace('?', 'a')
        upper = search_query.replace('?', 'z')
        left = bisect_left(target_list, lower)
        right = bisect_right(target_list, upper)
        answer.append(right - left)

    return answer


if __name__ == '__main__':
    inputs = [
        (["frodo", "front", "frost", "frozen", "frame", "kakao"],
         ["fro??", "????o", "fr???", "fro???", "pro?", "?????"],
         [3, 2, 4, 1, 0, 5])
    ]
    for words, queries, actual in inputs:
        expect = solution(words, queries)
        print(f"expect : {expect}, actual : {actual}")
