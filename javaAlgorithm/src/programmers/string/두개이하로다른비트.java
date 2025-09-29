package programmers.string;

public class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] % 2 == 0){
                answer[i] = numbers[i] + 1;
            }else{
                String s = "0" + Long.toString(numbers[i],2);
                int idx = s.lastIndexOf("0");
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(idx,'1');
                sb.setCharAt(idx + 1,'0');
                answer[i] = Long.parseLong(sb.toString(),2);
            }
        }
        return answer;
    }
}
