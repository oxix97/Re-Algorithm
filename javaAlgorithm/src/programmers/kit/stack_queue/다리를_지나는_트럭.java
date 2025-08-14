package programmers.kit.stack_queue;

import java.util.*;

public class 다리를_지나는_트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> trucks = new ArrayDeque<>();
        for(int truck : truck_weights){
            trucks.addLast(truck);
        }

        Deque<Node> bridge = new ArrayDeque<>();
        int time = 0;
        int finish = 0;
        int current_weight = 0;
        while (finish < truck_weights.length){
            time += 1;
            // 다리에 있는 트럭 이동
            Iterator<Node> it = bridge.iterator();
            while (it.hasNext()){
                Node truck = it.next();
                truck.addTime();
                // 시간이 다 된 트럭 하차
                if(truck.time == bridge_length){
                    current_weight -= truck.weight;
                    it.remove();
                    finish += 1;
                }
            }
            // 트럭을 다리에 올리기
            if(bridge.size() < bridge_length && !trucks.isEmpty()){
                if(current_weight + trucks.peekFirst() <= weight){
                    int truck = trucks.removeFirst();
                    bridge.addLast(new Node(truck, 0));
                    current_weight += truck;
                }
            }
        }

        return time;
    }

    static class Node implements Comparable<Node> {
        int weight;
        int time;

        public Node(int w, int t) {
            this.weight = w;
            this.time = t;
        }

        public void addTime() {
            this.time += 1;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }

    public static void main(String[] args) {
        int answer = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(answer);
    }
}
