package programmers.implement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        List<Person> persons = Arrays.stream(info)
                .map(Person::new)
                .collect(Collectors.toList());

        int[] answer = Arrays.stream(query)
                .mapToInt(it->{
                    int count = 0;
                    for(Person p : persons)
                        if(p.same(it))
                            count += 1;
                    return count;
                })
                .toArray();

        return answer;
    }

    class Person {
        String lang;
        String position;
        String career;
        String food;
        int point;

        public Person(String s){
            String[] info = s.split(" ");
            this.lang = info[0];
            this.position = info[1];
            this.career = info[2];
            this.food = info[3];
            this.point = Integer.parseInt(info[4]);
        }

        public boolean same(String query){
            String[] q = query.split(" ");
            boolean lang = check(this.lang,q[0]);
            boolean position = check(this.position,q[2]);
            boolean career = check(this.career,q[4]);
            boolean food = check(this.food,q[6]);
            boolean point = this.point >= Integer.parseInt(q[7]);
            StringBuilder sb = new StringBuilder();

            return lang && position && career && food && point;
        }

        private boolean check(String a, String b){
            return a.equals(b) || b.equals("-");
        }
    }
}
