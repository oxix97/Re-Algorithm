package programmers.kit.hash;

import java.util.*;
import java.util.stream.Collectors;

public class 베스트앨범 {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total_plays = new HashMap<>();
        Map<String, List<Song>> songs = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            total_plays.put(genres[i], total_plays.getOrDefault(genres[i], 0) + plays[i]);
            songs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        List<String> sorted_genres = total_plays.keySet().stream()
                .sorted((o1, o2) -> total_plays.get(o2).compareTo(total_plays.get(o1)))
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();

        for (String genre : sorted_genres) {
            int count = 0;
            List<Song> sorted_songs = songs.get(genre);
            Collections.sort(sorted_songs);

            for (Song song : sorted_songs) {
                if (count == 2) {
                    break;
                }
                count += 1;
                answer.add(song.idx);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static class Song implements Comparable<Song> {
        int idx;
        int play;

        public Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            return o.play - this.play;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = solution(genres, plays);
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
