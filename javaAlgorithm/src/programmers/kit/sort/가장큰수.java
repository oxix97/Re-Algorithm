package programmers.kit.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 가장큰수 {
    public String solution(int[] numbers) {
        List<Num> nums = new ArrayList<>();
        for(int n : numbers){
            nums.add(new Num(n));
        }

        Collections.sort(nums);

        StringBuilder sb = new StringBuilder();
        nums.forEach(it->sb.append(it.num));

        String answer = sb.toString();
        if(answer.startsWith("0")){
            return "0";
        }

        return sb.toString();
    }

    class Num implements Comparable<Num>{
        String num;

        public Num(int n){
            this.num = String.valueOf(n);
        }

        @Override
        public int compareTo(Num o){
            int a = Integer.parseInt(this.num + o.num);
            int b = Integer.parseInt(o.num + this.num);
            return b - a;
        }
    }
}
