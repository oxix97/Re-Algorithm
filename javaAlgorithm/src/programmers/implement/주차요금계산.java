package programmers.implement;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer,Integer> park = new HashMap<>();
        Map<Integer,Integer> fee = new HashMap<>();

        for(String record : records){
            String[] r = record.split(" ");
            int time = transfer(r[0]);
            int num = Integer.parseInt(r[1]);

            if(r[2].equals("IN")){
                park.put(num,time);
            }else{
                int used = time - park.get(num);
                fee.put(num,fee.computeIfAbsent(num,k->0)+used);
                park.remove(num);
            }
        }
        int out = transfer("23:59");
        for(int num : park.keySet()){
            int used = out - park.get(num);
            fee.put(num,fee.computeIfAbsent(num,k->0)+used);
        }

        List<Integer> keySet = new ArrayList<>(fee.keySet());
        Collections.sort(keySet);

        return keySet.stream()
                .mapToInt(it->{
                    int used = fee.get(it);
                    if(used <= fees[0]){
                        return fees[1];
                    }
                    double d = (double) (used - fees[0]) / fees[2];
                    return fees[1] + (int) Math.ceil(d) * fees[3];
                })
                .toArray();
    }

    private int transfer(String s){
        String[] t = s.split(":");
        int h = Integer.parseInt(t[0]) * 60;
        int m = Integer.parseInt(t[1]);
        return h + m;
    }
}
