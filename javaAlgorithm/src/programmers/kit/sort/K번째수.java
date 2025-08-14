package programmers.kit.sort;

import java.util.Arrays;

public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for(int[] c : commands){
            int from = c[0];
            int to = c[1];
            int k = c[2];
            int[] sorted_array = Arrays.copyOfRange(array,from-1,to);
            Arrays.sort(sorted_array);
            answer[idx] = sorted_array[k - 1];
            idx += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2,5,3},
                {4,4,1},
                {1,7,3}
        };
        int[] answer = solution(array, commands);
        for(int s : answer){
            System.out.println(s);
        }
    }
}
