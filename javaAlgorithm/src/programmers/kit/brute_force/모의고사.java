package programmers.kit.brute_force;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] a1 = {1,2,3,4,5};
        int[] a2 = {2,1,2,3,2,4,2,5};
        int[] a3 = {3,3,1,1,2,2,4,4,5,5};
        int[] result = new int[3];
        for(int i=0;i<answers.length;i++){
            if(a1[i % a1.length] == answers[i]){
                result[0] += 1;
            }
            if(a2[i % a2.length] == answers[i]){
                result[1] += 1;
            }
            if(a3[i % a3.length] == answers[i]){
                result[2] += 1;
            }
        }
        int max = IntStream.of(result).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(max == result[i]){
                list.add(i + 1);
            }
        }

        return list.stream()
                .mapToInt(it->it)
                .toArray();
    }
}
