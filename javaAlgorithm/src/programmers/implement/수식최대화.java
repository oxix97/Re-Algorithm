package programmers.implement;

import java.util.ArrayList;
import java.util.List;

public class 수식최대화 {
    char[] type = {'+', '-', '*'};
    boolean[] visit = new boolean[3];
    long answer = 0;
    public long solution(String expression) {
        List<Long> num = new ArrayList<>();
        List<Character> oper = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }else{
                num.add(Long.parseLong(sb.toString()));
                oper.add(c);
                sb = new StringBuilder();
            }
        }
        num.add(Long.parseLong(sb.toString()));

        recursion(0,new char[3], num,oper);

        return answer;
    }

    private void calculate(char[] priority, List<Long> num, List<Character> oper){
        List<Long> tnum = new ArrayList<>(num);
        List<Character> toper = new ArrayList<>(oper);

        for(char op : priority){
            for(int i=0;i<toper.size();i++){
                if(toper.get(i) == op){
                    long a = tnum.get(i);
                    long b = tnum.get(i + 1);
                    long result = calc(a,b,op);

                    tnum.set(i,result);
                    tnum.remove(i + 1);
                    toper.remove(i);
                    i--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(tnum.get(0)));
    }

    private void recursion(int depth, char[] priority, List<Long> num, List<Character> oper){
        if(depth == 3){
            calculate(priority,num,oper);
            return;
        }

        for(int i=0;i<3;i++){
            if(!visit[i]){
                visit[i] = true;
                priority[depth] = type[i];
                recursion(depth + 1,priority,num,oper);
                visit[i] = false;
            }
        }
    }


    private long calc(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }
}
