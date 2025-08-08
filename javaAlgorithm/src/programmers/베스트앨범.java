package programmers;

import java.util.*;

public class 베스트앨범 {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, List<Song>> map = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            List<Song> tmp = map.getOrDefault(genres[i], new ArrayList<>());
            tmp.add(new Song(i, plays[i]));
            map.put(genres[i], tmp);
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keySet = new ArrayList<>(total.keySet());
        keySet.sort((o1, o2) -> total.get(o2).compareTo(total.get(o1)));

        List<Integer> answer = new ArrayList<>();
        for (String key : keySet) {
            List<Song> songs = map.get(key);
            Collections.sort(songs);

            int cnt = 0;
            while (!songs.isEmpty() && cnt++ < 2)
                answer.add(songs.remove(0).idx);
        }

        int[] arr = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            arr[i] = answer.get(i);
        }
        return arr;
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
