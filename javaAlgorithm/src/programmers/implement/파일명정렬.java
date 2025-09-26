package programmers.implement;

import java.util.Arrays;

public class 파일명정렬 {
    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .map(File::new)
                .sorted()
                .map(it -> it.str)
                .toArray(String[]::new);
    }

    class File implements Comparable<File>{
        String str;
        String head = "";
        String number = "";

        public File(String s){
            this.str = s;
            int idx = 0;
            while(idx < s.length()){
                char c = s.charAt(idx);
                if('0' <= c && c <= '9')
                    break;
                idx += 1;
            }
            this.head = s.substring(0,idx);
            int start = idx;
            while(idx < s.length()){
                char c = s.charAt(idx);
                if('0' <= c && c <= '9'){
                    idx += 1;
                    continue;
                }
                break;
            }
            if(start != idx)
                this.number = s.substring(start,idx);
            else
                this.number = "";
        }

        @Override
        public int compareTo(File o){
            String a = this.head.toUpperCase();
            String b = o.head.toUpperCase();
            if(a.compareTo(b) == 0){
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }
            return a.compareTo(b);
        }
    }
}
