package programmers.implement;

import java.util.stream.IntStream;

public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        return IntStream.range(0,musicinfos.length)
                .mapToObj(i -> new Music(i, musicinfos[i]))
                .filter(it->it.check(m))
                .sorted()
                .map(it->it.title)
                .findFirst()
                .orElse("(None)");
    }

    class Music implements Comparable<Music>{
        int idx;
        int start;
        int end;
        String title;
        String melody;

        public Music(int i, String m){
            String[] s = m.split(",");
            this.idx = i;
            this.start = stringToTime(s[0]);
            this.end = stringToTime(s[1]);
            this.title = s[2];
            this.melody = transfer(s[3]);
        }

        private int stringToTime(String str){
            String[] s = str.split(":");
            return Integer.parseInt(s[1]) + Integer.parseInt(s[0]) * 60;
        }

        public String transfer(String m){
            return m.replaceAll("C#", "H")
                    .replaceAll("D#", "I")
                    .replaceAll("F#", "J")
                    .replaceAll("G#", "K")
                    .replaceAll("A#", "L")
                    .replaceAll("B#","M")
                    .replaceAll("E#","N");
        }

        public String getFullMelody(){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<end-start;i++)
                sb.append(this.melody.charAt(i % this.melody.length()));
            return sb.toString();
        }

        public boolean check(String m){
            String target = transfer(m);
            String fullMelody = getFullMelody();
            return fullMelody.contains(target);
        }

        @Override
        public int compareTo (Music o){
            int o1 = this.end - this.start;
            int o2 = o.end - o.start;
            if(o1 == o2){
                return this.idx - o.idx;
            }
            return o2 - o1;
        }
    }
}
