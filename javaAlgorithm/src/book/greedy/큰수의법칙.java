package book.greedy;

import java.util.Arrays;

public class 큰수의법칙 {
    public static void main(String []args) {
        //input
        int n =5;
        int m = 8;
        int k = 3;
        Integer[] a1 = {2,4,5,4,6};
        Integer[] a2 = {3,4,3,4,3};

        solution(n,m,k,a1);
        solution(n,m,k,a2);
    }

    private static void solution(int n,int m, int k, Integer[] arr){
        //solution
        Arrays.sort(arr,(a, b) -> b - a);
        int sum = 0;

        while(m > 0){
            int cnt = 0;
            while(m-- != 0 && cnt++ < k) sum += arr[0];
            if(m-- != 0) sum += arr[1];
        }

        System.out.println(sum);
    }
}
