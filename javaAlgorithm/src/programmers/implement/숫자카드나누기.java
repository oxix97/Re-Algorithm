package programmers.implement;

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int a = find(arrayA);
        int b = find(arrayB);

        return Math.max(check(a,arrayB),check(b,arrayA));
    }

    private int check(int n, int[] arr){
        for(int num : arr){
            if(num % n == 0)
                return 0;
        }
        return n;
    }

    private int find(int[] arr){
        int n = arr[0];
        for(int i=1;i<arr.length;i++)
            n = gcd(n,arr[i]);
        return n;
    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
