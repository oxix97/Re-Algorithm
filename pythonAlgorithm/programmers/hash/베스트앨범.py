from collections import Counter, defaultdict

def solution(genres, plays):
    most_genre = defaultdict(list)
    sum_genre = Counter()

    for idx, (genre, play) in enumerate(zip(genres, plays)):
        most_genre[genre].append((play, idx))
        sum_genre[genre] += play

    # 총 재생 수 기준으로 장르 내림차순 정렬
    sorted_genres = [genre for genre, _ in sum_genre.most_common()]

    answer = []
    for genre in sorted_genres:
        songs = sorted(most_genre[genre], key=lambda x: (-x[0], x[1]))
        answer.extend([idx for _, idx in songs[:2]])

    return answer
